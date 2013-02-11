package com.trigonic.jedis;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.*;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static redis.clients.jedis.BinaryClient.LIST_POSITION.AFTER;
import static redis.clients.jedis.BinaryClient.LIST_POSITION.BEFORE;

public class NamespaceTransactionTest {
  private Jedis jedis;
  private NamespaceJedisPool namespacedPool;
  private NamespaceJedis namespaced;
  private NamespaceTransaction transaction;

  @Before
  public void setup() {
    jedis = new Jedis("localhost");
    jedis.flushDB();

    namespacedPool = new NamespaceJedisPool("localhost").withNamespace("ns");
    namespaced = (NamespaceJedis) namespacedPool.getResource();
    jedis.set("foo", "bar");
  }

  @After
  public void tearDown() {
    namespacedPool.returnResource(namespaced);

    jedis.flushDB();
    jedis.quit();
  }

  @Test
  public void shouldBeAbleToUseANamespaceWithinMulti() {
    transaction = namespaced.multi();
    Response<String> nsFoo = transaction.get("foo");
    transaction.exec();

    assertNull(nsFoo.get());

    transaction = namespaced.multi();
    transaction.set("foo", "chris");
    nsFoo = transaction.get("foo");
    transaction.exec();

    assertEquals("bar", jedis.get("foo"));
    assertEquals("chris", nsFoo.get());
    assertEquals("chris", jedis.get("ns:foo"));

    transaction = namespaced.multi();
    jedis.set("foo", "bob");
    nsFoo = transaction.get("foo");
    transaction.exec();

    assertEquals("bob", jedis.get("foo"));
    assertEquals("chris", nsFoo.get());
    assertEquals("chris", jedis.get("ns:foo"));

    transaction = namespaced.multi();
    transaction.incrBy("counter", 2);
    Response<String> nsCounter = transaction.get("counter");
    Response<String> nsCounterType = transaction.type("counter");
    transaction.exec();

    assertEquals("2", nsCounter.get());
    assertNull(jedis.get("counter"));
    assertEquals("string",nsCounterType.get());
  }



  @Test
  public void shouldBeAbleToUseANamespaceWithDelWithinMulti() {
    transaction = namespaced.multi();

    transaction.set("foo", "1000");
    transaction.set("bar", "2000");
    transaction.set("baz", "3000");
    Response<Set<String>> keys = transaction.keys("*");
    transaction.del("foo");
    transaction.get("foo");
    transaction.del("bar", "baz");
    transaction.get("bar");
    transaction.get("baz");
    transaction.keys("*");

    List<Object> response = transaction.exec();

    // note that fetching the keys response directly allows us to wrap
    // it in namespace.remove() whereas fetching it from the List returned
    // by exec() affords us no such luxury. Since pipelinedResponses is
    // private to redis.clients.jedis.Queable we can't just create a
    // monkey-patched version of redis.clients.jedis.Queable#getResponse that
    // handles calling namespace.remove() where needed, and it seems like
    // overkill to rewrite NamespaceTransaction's inheritance chain just
    // to get this minor behavior working the same. For now, this test
    // documents the GOTCHA.
    assertEquals(asSet("ns:foo", "ns:bar", "ns:baz"), response.get(3));
    assertEquals(asSet("foo", "bar", "baz"), keys.get());

    assertNull(response.get(5));
    assertNull(response.get(7));
    assertNull(response.get(8));
    assertEquals(asSet(),response.get(9));
  }


  @Test
  public void shouldBeAbleToUseANamespaceWithMgetWithinMulti() {
    transaction = namespaced.multi();

    transaction.set("foo", "1000");
    transaction.set("bar", "2000");
    transaction.mget("foo", "bar");
    transaction.mget("foo", "bar", "baz");

    List<Object> response = transaction.exec();

    assertEquals(asList("1000", "2000"), response.get(2));
    assertEquals(asList("1000", "2000", null), response.get(3));
  }

  @Test
  public void shouldBeAbleToUseANamespaceWithMsetWithinMulti() {
    transaction = namespaced.multi();

    transaction.mset("foo", "1000", "bar", "2000");
    transaction.mget("foo", "bar");
    transaction.mget("foo", "bar", "baz");

    List<Object> response = transaction.exec();
    assertEquals(asList("1000", "2000"), response.get(1));
    assertEquals(asList("1000", "2000", null), response.get(2));
  }

  @Test
  public void shouldBeAbleToUseANamespaceWithMsetnxWithinMulti() {
    transaction = namespaced.multi();
    transaction.msetnx("foo", "1000", "bar", "2000");
    transaction.mget("foo", "bar");
    transaction.mget("foo", "bar", "baz");

    List<Object> response = transaction.exec();

    assertEquals(asList("1000", "2000"), response.get(1));
    assertEquals(asList("1000", "2000", null), response.get(2));
  }

  @Test
  public void shouldBeAbleToUseANamespaceWithHashesWithinMulti() {
    transaction = namespaced.multi();
    transaction.hset("foo", "key", "value");
    transaction.hset("foo", "key1", "value1");
    transaction.hget("foo", "key");
    transaction.hgetAll("foo");
    transaction.hlen("foo");
    transaction.hkeys("foo");
    List<Object> response = transaction.exec();
    assertEquals("value", response.get(2));
    assertEquals(asMap("key", "value", "key1", "value1"), response.get(3));
    assertEquals(Long.valueOf(2), response.get(4));
    assertEquals(asSet("key", "key1"), response.get(5));

    transaction = namespaced.multi();
    transaction.hmset("bar", asMap("key", "value", "key1", "value1"));
    transaction.hmget("bar", "key", "key1");
    transaction.hmset("bar", asMap("a_number", "1"));
    transaction.hmget("bar", "a_number");
    response = transaction.exec();
    assertEquals(asList("1"), response.get(3));

    transaction = namespaced.multi();
    transaction.hincrBy("bar", "a_number", 3);
    transaction.hmget("bar", "a_number");
    transaction.hgetAll("bar");
    transaction.hsetnx("foonx", "nx", "10");
    transaction.hsetnx("foonx", "nx", "12");
    transaction.hget("foonx", "nx");
    transaction.hkeys("foonx");
    transaction.hvals("foonx");
    transaction.hmset("baz", asMap("key", "value", "key1", "value1", "a_number", "4"));
    transaction.hgetAll("baz");
    response = transaction.exec();

    assertEquals(asList("4"), response.get(1));
    assertEquals(asMap("key", "value", "key1", "value1", "a_number", "4"), response.get(2));

    assertEquals(Long.valueOf(1), response.get(3) );
    assertEquals(Long.valueOf(0), response.get(4));
    assertEquals("10", response.get(5));
    assertEquals(asSet("nx"), response.get(6));
    assertEquals(asList("10"), response.get(7));
    assertEquals(asMap("key", "value", "key1", "value1", "a_number", "4"), response.get(9));
  }

  @Test
  public void shouldProperlyMoveMemberBetweenSetsWithinMulti() {
    transaction = namespaced.multi();
    transaction.sadd("foo", "1");
    transaction.sadd("foo", "2");
    transaction.sadd("foo", "3");
    transaction.sadd("bar", "2");
    transaction.sadd("bar", "3");
    transaction.smembers("foo");
    transaction.smembers("bar");
    List<Object> response = transaction.exec();
    assertEquals(asSet("1", "2", "3"), response.get(5));
    assertEquals(asSet("2", "3"), response.get(6));

    transaction = namespaced.multi();
    transaction.smove("foo", "bar", "1");
    transaction.smembers("foo");
    transaction.smembers("bar");
    response = transaction.exec();
    assertEquals(asSet("2", "3"), response.get(1) );
    assertEquals(asSet("1", "2", "3"), response.get(2));
  }

  @Test
  public void shouldProperlyIntersectThreeSetsWithinMulti() {
    transaction = namespaced.multi();
    transaction.sadd("foo", "1");
    transaction.sadd("foo", "2");
    transaction.sadd("foo", "3");
    transaction.sadd("bar", "2");
    transaction.sadd("bar", "3");
    transaction.sadd("bar", "4");
    transaction.sadd("baz", "3");
    transaction.sinter("foo", "bar", "baz");
    List<Object> response = transaction.exec();

    assertEquals(asSet("3"), response.get(7) );
  }

  @Test
  public void shouldProperlyUnionTwoSetsWithinMulti() {
    transaction = namespaced.multi();
    transaction.sadd("foo", "1");
    transaction.sadd("foo", "2");
    transaction.sadd("bar", "2");
    transaction.sadd("bar", "3");
    transaction.sadd("bar", "4");
    transaction.sunion("foo", "bar");
    List<Object> response = transaction.exec();

    assertEquals(asSet("1", "2", "3", "4"), response.get(5));
  }

  @Test
  public void shouldProperlyUnionTwoSortedSetsWithOptionsWithinMulti() {
    transaction = namespaced.multi();
    transaction.zadd("sort1", 1, "1");
    transaction.zadd("sort1", 2, "2");
    transaction.zadd("sort2", 2, "2");
    transaction.zadd("sort2", 3, "3");
    transaction.zadd("sort2", 4, "4");
    transaction.zunionstore("union", new ZParams().weights(2, 1), "sort1", "sort2");
    transaction.zrevrange("union", 0, -1);
    List<Object> response = transaction.exec();

    assertEquals(asSet("2", "4", "3", "1"), response.get(6) );
  }

  @Test
  public void shouldProperlyUnionTwoSortedSetsWithoutOptionsWithinMulti() {
    transaction = namespaced.multi();
    transaction.zadd("sort1", 1, "1");
    transaction.zadd("sort1", 2, "2");
    transaction.zadd("sort2", 2, "2");
    transaction.zadd("sort2", 3, "3");
    transaction.zadd("sort2", 4, "4");
    transaction.zunionstore("union", "sort1", "sort2");
    transaction.zrevrange("union", 0, -1);
    List<Object> response = transaction.exec();

    assertEquals(asSet("4", "2", "3", "1"), response.get(6));
  }

  @Test
  public void shouldAddNamespaceToSortWithinMulti() {
    transaction = namespaced.multi();
    transaction.sadd("foo", "1");
    transaction.sadd("foo", "2");
    transaction.set("weight_1", "2");
    transaction.set("weight_2", "1");
    transaction.set("value_1", "a");
    transaction.set("value_2", "b");
    transaction.sort("foo");
    transaction.sort("foo", new SortingParams().limit(0, 1));
    transaction.sort("foo", new SortingParams().desc());
    transaction.sort("foo", new SortingParams().by("weight_*"));
    transaction.sort("foo", new SortingParams().get("value_*"));

    // sort inside multi with STORE dstkey doesn't currently work
    // see https://github.com/xetorthio/jedis/pull/389 for my fix
//    transaction.sort("foo", "result");
//    transaction.lrange("result", 0, -1);
    List<Object> response = transaction.exec();

    assertEquals(asList("1", "2"), response.get(6));
    assertEquals(asList("1"), response.get(7));
    assertEquals(asList("2", "1"), response.get(8));
    assertEquals(asList("2", "1"), response.get(9));
    assertEquals(asList("a", "b"),response.get(10));
//    assertEquals(asList("1", "2"), response.get(12) );
  }

  @Test
  public void shouldYieldTheCorrectListOfKeysWithinMulti() {
    transaction = namespaced.multi();

    transaction.set("foo", "1");
    transaction.set("bar", "2");
    transaction.set("baz", "3");
    Response<Set<String>> keys = transaction.keys("*");
    List<Object> response = transaction.exec();

    assertEquals(asSet("bar", "baz", "foo"), keys.get());
    assertEquals(asSet("ns:bar", "ns:baz", "ns:foo"), response.get(3));

  }


  @Test
  public void shouldBeAbleToUseANamespaceWithAppendWithinMulti() {
    transaction = namespaced.multi();
    transaction.get("foo");
    transaction.append("foo", "foo");
    transaction.append("foo", "bar");
    transaction.get("foo");
    List<Object> response = transaction.exec();
    assertNull(response.get(0));
    assertEquals("foobar", response.get(3));
    assertEquals("foobar", jedis.get("ns:foo"));
  }

  @Test
  public void shouldBeAbleToUseANamespaceWithIncrDecrWithinMulti() {

    transaction = namespaced.multi();
    transaction.get("foo");
    transaction.incr("foo");
    transaction.get("foo");
    transaction.incrBy("foo", 3);
    transaction.get("foo");
    transaction.decr("foo");
    transaction.get("foo");
    transaction.decrBy("foo", 3);
    transaction.get("foo");
    List<Object> response = transaction.exec();

    assertNull(response.get(0));
    assertEquals("1", response.get(2));
    assertEquals("4", response.get(4));
    assertEquals("3", response.get(6) );
    assertEquals("0",response.get(8));
  }

  @Test
  public void shouldBeAbleToUseANamespaceWithListsWithinMulti() {
    transaction = namespaced.multi();
    transaction.get("foo");
    transaction.lpushx("foo", "bar");
    transaction.get("foo");
    transaction.lpush("foo", "20");
    transaction.lpush("foo", "10");
    transaction.linsert("foo", AFTER, "20", "40");
    transaction.linsert("foo", BEFORE, "40", "30");
    transaction.llen("foo");
    transaction.lindex("foo", 0);
    transaction.lrange("foo", 1, 2);
    transaction.lset("foo", 0, "40");
    transaction.lrem("foo", 1, "40");
    transaction.ltrim("foo", 1, 2);
    transaction.lrange("foo", 0, 3);
    List<Object> response = transaction.exec();

    assertNull(response.get(0));
    assertNull(response.get(2));
    assertEquals(Long.valueOf(4), response.get(7));
    assertEquals("10", response.get(8));
    assertEquals(asList("20", "30"), response.get(9));
    assertEquals(asList("30", "40"), response.get(13));
  }


//  @Test
//  public void multiBlock() {
//    List<Object> response = namespaced.multi(new NamespaceTransactionBlock(new NamespaceHandler("ns")) {
//      @Override
//      public void execute() {
//        sadd("foo", "a");
//        sadd("foo", "b");
//        scard("foo");
//      }
//    });
//
//    List<Object> expected = new ArrayList<Object>();
//    expected.add(1L);
//    expected.add(1L);
//    expected.add(2L);
//    assertEquals(expected, response);
////
////    // Binary
////    response = jedis.multi(new TransactionBlock() {
////      @Override
////      public void execute() {
////        sadd(bfoo, ba);
////        sadd(bfoo, bb);
////        scard(bfoo);
////      }
////    });
////
////    expected = new ArrayList<Object>();
////    expected.add(1L);
////    expected.add(1L);
////    expected.add(2L);
////    assertEquals(expected, response);
//
//  }
  protected static <T> Set<T> asSet(T... values) {
    return new HashSet<T>(asList(values));
  }

  protected static <T> Map<T, T> asMap(T... keyvalues) {
    Builder<T, T> builder = ImmutableMap.builder();
    for (int i = 0; i < keyvalues.length; i += 2) {
      T key = keyvalues[i], value = null;
      if (i + 1 < keyvalues.length) {
        value = keyvalues[i + 1];
      }
      builder.put(key, value);
    }
    return builder.build();
  }
}

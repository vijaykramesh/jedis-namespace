package com.trigonic.jedis;

import redis.clients.jedis.*;

import com.trigonic.jedis.NamespaceTransactionInterface.DefaultNamespaceTransaction;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NamespaceTransaction extends Transaction implements InvocationHandler {

  private DefaultNamespaceTransaction defaultNamespaceTransaction;

  public NamespaceTransaction(NamespaceHandler namespace) {
    super();
    this.defaultNamespaceTransaction = new DefaultNamespaceTransaction(namespace);

  }
  public NamespaceTransaction(NamespaceHandler namespace, final Client client) {
    super(client);
    System.out.println("setting default!");
    this.defaultNamespaceTransaction = new DefaultNamespaceTransaction(client, namespace);

  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args)
      throws Throwable {
    System.out.println("invoke!");
    if(Object.class  == method.getDeclaringClass()) {
      String name = method.getName();
      if("equals".equals(name)) {
        return proxy == args[0];
      } else if("hashCode".equals(name)) {
        return System.identityHashCode(proxy);
      } else if("toString".equals(name)) {
        return proxy.getClass().getName() + "@" +
            Integer.toHexString(System.identityHashCode(proxy)) +
            ", with InvocationHandler " + this;
      } else {
        throw new IllegalStateException(String.valueOf(method));
      }
    }
    System.out.println(method.toString());
    return method.invoke(defaultNamespaceTransaction, args);
  }
}
//
//  @Override
//  public Response<Long> append(String key, String value) {
//    return defaultNamespaceTransaction.append(key, value);
//  }
//
//
//  @Override
//  public Response<List<String>> blpop(String... args) {
//    return defaultNamespaceTransaction.blpop(args);
//  }
//
//  @Override
//  public Response<List<String>> brpop(String... args) {
//    return defaultNamespaceTransaction.brpop(args);
//  }
//
//  @Override
//  public Response<Long> decr(String key) {
//    return defaultNamespaceTransaction.decr(key);
//  }
//
//  @Override
//  public Response<Long> decrBy(String key, long integer) {
//    return defaultNamespaceTransaction.decrBy(key, integer);
//  }
//
//  @Override
//  public Response<Long> del(String... keys) {
//    return defaultNamespaceTransaction.del(keys);
//  }
//
//  @Override
//  public Response<Boolean> exists(String key) {
//    return defaultNamespaceTransaction.exists(key);
//  }
//
//  @Override
//  public Response<Long> expire(String key, int seconds) {
//    return defaultNamespaceTransaction.expire(key, seconds);
//  }
//
//  @Override
//  public Response<Long> expireAt(String key, long unixTime) {
//    return defaultNamespaceTransaction.expireAt(key, unixTime);
//  }
//
//  @Override
//  public Response<String> get(String key) {
//    return defaultNamespaceTransaction.get(key);
//  }
//
//  @Override
//  public Response<Boolean> getbit(String key, long offset) {
//    return defaultNamespaceTransaction.getbit(key, offset);
//  }
//
//  @Override
//  public Response<String> getrange(String key, long startOffset,
//                                   long endOffset) {
//    return defaultNamespaceTransaction.getrange(key, startOffset, endOffset);
//  }
//
//  @Override
//  public Response<String> getSet(String key, String value) {
//    return defaultNamespaceTransaction.getSet(key, value);
//  }
//
//  @Override
//  public Response<Long> hdel(String key, String field) {
//    return defaultNamespaceTransaction.hdel(key, field);
//  }
//
//  @Override
//  public Response<Boolean> hexists(String key, String field) {
//    return defaultNamespaceTransaction.hexists(key, field);
//  }
//
//  @Override
//  public Response<String> hget(String key, String field) {
//    return defaultNamespaceTransaction.hget(key, field);
//  }
//
//  @Override
//  public Response<Map<String, String>> hgetAll(String key) {
//    return defaultNamespaceTransaction.hgetAll(key);
//  }
//
//  @Override
//  public Response<Long> hincrBy(String key, String field, long value) {
//    return defaultNamespaceTransaction.hincrBy(key, field, value);
//  }
//
//  @Override
//  public Response<Set<String>> hkeys(String key) {
//    return defaultNamespaceTransaction.hkeys(key);
//  }
//
//  @Override
//  public Response<Long> hlen(String key) {
//    return defaultNamespaceTransaction.hlen(key);
//  }
//
//  @Override
//  public Response<List<String>> hmget(String key, String... fields) {
//    return defaultNamespaceTransaction.hmget(key, fields);
//  }
//
//  @Override
//  public Response<String> hmset(String key, Map<String, String> hash) {
//    return defaultNamespaceTransaction.hmset(key, hash);
//  }
//
//  @Override
//  public Response<Long> hset(String key, String field, String value) {
//    return defaultNamespaceTransaction.hset(key, field, value);
//  }
//
//  @Override
//  public Response<Long> hsetnx(String key, String field, String value) {
//    return defaultNamespaceTransaction.hsetnx(key, field, value);
//  }
//
//  @Override
//  public Response<List<String>> hvals(String key) {
//    return defaultNamespaceTransaction.hvals(key);
//  }
//
//  @Override
//  public Response<Long> incr(String key) {
//    return defaultNamespaceTransaction.incr(key);
//  }
//
//  @Override
//  public Response<Long> incrBy(String key, long integer) {
//    return defaultNamespaceTransaction.incrBy(key, integer);
//  }
//
//  @Override
//  public Response<Set<String>> keys(String pattern) {
//    return defaultNamespaceTransaction.keys(pattern);
//  }
//
//  @Override
//  public Response<String> lindex(String key, int index) {
//    return defaultNamespaceTransaction.lindex(key, index);
//  }
//
//  @Override
//  public Response<Long> linsert(String key, BinaryClient.LIST_POSITION where,
//                                String pivot, String value) {
//    return defaultNamespaceTransaction.linsert(key, where, pivot, value);
//  }
//
//  @Override
//  public Response<Long> llen(String key) {
//    return defaultNamespaceTransaction.llen(key);
//  }
//
//  @Override
//  public Response<String> lpop(String key) {
//    return defaultNamespaceTransaction.lpop(key);
//  }
//
//  @Override
//  public Response<Long> lpush(String key, String string) {
//    return defaultNamespaceTransaction.lpush(key, string);
//  }
//
//  @Override
//  public Response<Long> lpushx(String key, String string) {
//    return defaultNamespaceTransaction.lpushx(key, string);
//  }
//
//  @Override
//  public Response<List<String>> lrange(String key, long start, long end) {
//    return defaultNamespaceTransaction.lrange(key, start, end);
//  }
//
//  @Override
//  public Response<Long> lrem(String key, long count, String value) {
//    return defaultNamespaceTransaction.lrem(key, count, value);
//  }
//
//  @Override
//  public Response<String> lset(String key, long index, String value) {
//    return defaultNamespaceTransaction.lset(key, index, value);
//  }
//
//  @Override
//  public Response<String> ltrim(String key, long start, long end) {
//    return defaultNamespaceTransaction.ltrim(key, start, end);
//  }
//
//  @Override
//  public Response<List<String>> mget(String... keys) {
//    return defaultNamespaceTransaction.mget(keys);
//  }
//
//  @Override
//  public Response<Long> move(String key, int dbIndex) {
//    return defaultNamespaceTransaction.move(key, dbIndex);
//  }
//
//  @Override
//  public Response<String> mset(String... keysvalues) {
//    return defaultNamespaceTransaction.mset(keysvalues);
//  }
//
//  @Override
//  public Response<Long> msetnx(String... keysvalues) {
//    return defaultNamespaceTransaction.msetnx(keysvalues);
//  }
//
//  @Override
//  public Response<Long> persist(String key) {
//    return defaultNamespaceTransaction.persist(key);
//  }
//
//  @Override
//  public Response<String> rename(String oldkey, String newkey) {
//    return defaultNamespaceTransaction.rename(oldkey, newkey);
//  }
//
//  @Override
//  public Response<Long> renamenx(String oldkey, String newkey) {
//    client.renamenx(namespace.add(oldkey), namespace.add(newkey));
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<String> rpop(String key) {
//    client.rpop(namespace.add(key));
//    return getResponse(BuilderFactory.STRING);
//  }
//
//  @Override
//  public Response<String> rpoplpush(String srckey, String dstkey) {
//    client.rpoplpush(namespace.add(srckey), namespace.add(dstkey));
//    return getResponse(BuilderFactory.STRING);
//  }
//
//  @Override
//  public Response<Long> rpush(String key, String string) {
//    client.rpush(namespace.add(key), string);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> rpushx(String key, String string) {
//    client.rpushx(namespace.add(key), string);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> sadd(String key, String member) {
//    client.sadd(namespace.add(key), member);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> scard(String key) {
//    client.scard(namespace.add(key));
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Set<String>> sdiff(String... keys) {
//    client.sdiff(namespace.add(keys));
//    return getResponse(BuilderFactory.STRING_SET);
//  }
//
//  @Override
//  public Response<Long> sdiffstore(String dstkey, String... keys) {
//    client.sdiffstore(namespace.add(dstkey), namespace.add(keys));
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<String> set(String key, String value) {
//    client.set(namespace.add(key), value);
//    return getResponse(BuilderFactory.STRING);
//  }
//
//  @Override
//  public Response<Boolean> setbit(String key, long offset, boolean value) {
//    client.setbit(namespace.add(key), offset, value);
//    return getResponse(BuilderFactory.BOOLEAN);
//  }
//
//  @Override
//  public Response<String> setex(String key, int seconds, String value) {
//    client.setex(namespace.add(key), seconds, value);
//    return getResponse(BuilderFactory.STRING);
//  }
//
//  @Override
//  public Response<Long> setnx(String key, String value) {
//    client.setnx(namespace.add(key), value);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> setrange(String key, long offset, String value) {
//    client.setrange(namespace.add(key), offset, value);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Set<String>> sinter(String... keys) {
//    client.sinter(namespace.add(keys));
//    return getResponse(BuilderFactory.STRING_SET);
//  }
//
//  @Override
//  public Response<Long> sinterstore(String dstkey, String... keys) {
//    client.sinterstore(namespace.add(dstkey), namespace.add(keys));
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Boolean> sismember(String key, String member) {
//    client.sismember(namespace.add(key), member);
//    return getResponse(BuilderFactory.BOOLEAN);
//  }
//
//  @Override
//  public Response<Set<String>> smembers(String key) {
//    client.smembers(namespace.add(key));
//    return getResponse(BuilderFactory.STRING_SET);
//  }
//
//  @Override
//  public Response<Long> smove(String srckey, String dstkey, String member) {
//    client.smove(namespace.add(srckey), namespace.add(dstkey), member);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<List<String>> sort(String key) {
//    client.sort(namespace.add(key));
//    return getResponse(BuilderFactory.STRING_LIST);
//  }
//
//  @Override
//  public Response<List<String>> sort(String key,
//                                     SortingParams sortingParameters) {
//    client.sort(namespace.add(key), namespace.add(sortingParameters));
//    return getResponse(BuilderFactory.STRING_LIST);
//  }
//
//  @Override
//  public Response<List<String>> sort(String key,
//                                     SortingParams sortingParameters, String dstkey) {
//    client.sort(namespace.add(key), namespace.add(sortingParameters), namespace.add(dstkey));
//    return getResponse(BuilderFactory.STRING_LIST);
//  }
//
//  @Override
//  public Response<List<String>> sort(String key, String dstkey) {
//    client.sort(namespace.add(key), namespace.add(dstkey));
//    return getResponse(BuilderFactory.STRING_LIST);
//  }
//
//  @Override
//  public Response<String> spop(String key) {
//    client.spop(namespace.add(key));
//    return getResponse(BuilderFactory.STRING);
//  }
//
//  @Override
//  public Response<String> srandmember(String key) {
//    client.srandmember(namespace.add(key));
//    return getResponse(BuilderFactory.STRING);
//  }
//
//  @Override
//  public Response<Long> srem(String key, String member) {
//    client.srem(namespace.add(key), member);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> strlen(String key) {
//    client.strlen(namespace.add(key));
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<String> substr(String key, int start, int end) {
//    client.substr(namespace.add(key), start, end);
//    return getResponse(BuilderFactory.STRING);
//  }
//
//  @Override
//  public Response<Set<String>> sunion(String... keys) {
//    client.sunion(namespace.add(keys));
//    return getResponse(BuilderFactory.STRING_SET);
//  }
//
//  @Override
//  public Response<Long> sunionstore(String dstkey, String... keys) {
//    client.sunionstore(namespace.add(dstkey), namespace.add(keys));
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> ttl(String key) {
//    client.ttl(namespace.add(key));
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<String> type(String key) {
//    client.type(namespace.add(key));
//    return getResponse(BuilderFactory.STRING);
//  }
//
//  @Override
//  public Response<Long> zadd(String key, double score, String member) {
//    client.zadd(namespace.add(key), score, member);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> zcard(String key) {
//    client.zcard(namespace.add(key));
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> zcount(String key, double min, double max) {
//    client.zcount(namespace.add(key), min, max);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Double> zincrby(String key, double score, String member) {
//    client.zincrby(namespace.add(key), score, member);
//    return getResponse(BuilderFactory.DOUBLE);
//  }
//
//  @Override
//  public Response<Long> zinterstore(String dstkey, String... sets) {
//    client.zinterstore(namespace.add(dstkey), sets);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> zinterstore(String dstkey, ZParams params,
//                                    String... sets) {
//    client.zinterstore(namespace.add(dstkey), params, sets);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Set<String>> zrange(String key, int start, int end) {
//    client.zrange(namespace.add(key), start, end);
//    return getResponse(BuilderFactory.STRING_ZSET);
//  }
//
//  @Override
//  public Response<Set<String>> zrangeByScore(String key, double min,
//                                             double max) {
//    client.zrangeByScore(namespace.add(key), min, max);
//    return getResponse(BuilderFactory.STRING_ZSET);
//  }
//
//  @Override
//  public Response<Set<String>> zrangeByScore(String key, String min,
//                                             String max) {
//    client.zrangeByScore(namespace.add(key), min, max);
//    return getResponse(BuilderFactory.STRING_ZSET);
//  }
//
//  @Override
//  public Response<Set<String>> zrangeByScore(String key, double min,
//                                             double max, int offset, int count) {
//    client.zrangeByScore(namespace.add(key), min, max, offset, count);
//    return getResponse(BuilderFactory.STRING_ZSET);
//  }
//
//  @Override
//  public Response<Set<Tuple>> zrangeByScoreWithScores(String key, double min,
//                                                      double max) {
//    client.zrangeByScoreWithScores(namespace.add(key), min, max);
//    return getResponse(BuilderFactory.TUPLE_ZSET);
//  }
//
//  @Override
//  public Response<Set<Tuple>> zrangeByScoreWithScores(String key, double min,
//                                                      double max, int offset, int count) {
//    client.zrangeByScoreWithScores(namespace.add(key), min, max, offset, count);
//    return getResponse(BuilderFactory.TUPLE_ZSET);
//  }
//
//  @Override
//  public Response<Set<Tuple>> zrangeWithScores(String key, int start, int end) {
//    client.zrangeWithScores(namespace.add(key), start, end);
//    return getResponse(BuilderFactory.TUPLE_ZSET);
//  }
//
//  @Override
//  public Response<Long> zrank(String key, String member) {
//    client.zrank(namespace.add(key), member);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> zrem(String key, String member) {
//    client.zrem(namespace.add(key), member);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> zremrangeByRank(String key, int start, int end) {
//    client.zremrangeByRank(namespace.add(key), start, end);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> zremrangeByScore(String key, double start, double end) {
//    client.zremrangeByScore(namespace.add(key), start, end);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Set<String>> zrevrange(String key, int start, int end) {
//    client.zrevrange(namespace.add(key), start, end);
//    return getResponse(BuilderFactory.STRING_ZSET);
//  }
//
//  @Override
//  public Response<Set<Tuple>> zrevrangeWithScores(String key, int start,
//                                                  int end) {
//    client.zrevrangeWithScores(namespace.add(key), start, end);
//    return getResponse(BuilderFactory.TUPLE_ZSET);
//  }
//
//  @Override
//  public Response<Long> zrevrank(String key, String member) {
//    client.zrevrank(namespace.add(key), member);
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Double> zscore(String key, String member) {
//    client.zscore(namespace.add(key), member);
//    return getResponse(BuilderFactory.DOUBLE);
//  }
//
//  @Override
//  public Response<Long> zunionstore(String dstkey, String... sets) {
//    client.zunionstore(namespace.add(dstkey), namespace.add(sets));
//    return getResponse(BuilderFactory.LONG);
//  }
//
//  @Override
//  public Response<Long> zunionstore(String dstkey, ZParams params,
//                                    String... sets) {
//    client.zunionstore(namespace.add(dstkey), params, namespace.add(sets));
//    return getResponse(BuilderFactory.LONG);
//  }


//}
package com.trigonic.jedis;

import redis.clients.jedis.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface JedisInterface<L, LS, B, S, MSS, SS, ST, D> {

  public L append(String key, String value);

  public LS blpop(String... args);

  public LS brpop(String... args);

  public L decr(String key);

  public L decrBy(String key, long integer);

  public L del(String... keys);

  public B exists(String key);

  public L expire(String key, int seconds);

  public L expireAt(String key, long unixTime);

  public S get(String key);

  public B getbit(String key, long offset);

  public S getrange(String key, long startOffset, long endOffset);

  public S getSet(String key, String value);

  public L hdel(String key, String field);

  public B hexists(String key, String field);

  public S hget(String key, String field);

  public MSS hgetAll(String key);

  public L hincrBy(String key, String field, long value);

  public SS hkeys(String key);

  public L hlen(String key);

  public LS hmget(String key, String... fields);

  public S hmset(String key, Map<String, String> hash);

  public L hset(String key, String field, String value);

  public L hsetnx(String key, String field, String value);

  public LS hvals(String key);

  public L incr(String key);

  public L incrBy(String key, long integer);

  public SS keys(String pattern);

  public S lindex(String key, int index);

  public L linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value);

  public L llen(String key);

  public S lpop(String key);

  public L lpush(String key, String string);

  public L lpushx(String key, String string);

  public LS lrange(String key, long start, long end);

  public L lrem(String key, long count, String value);

  public S lset(String key, long index, String value);

  public S ltrim(String key, long start, long end);

  public LS mget(String... keys);

  public L move(String key, int dbIndex);

  public S mset(String... keysvalues);

  public L msetnx(String... keysvalues);

  public L persist(String key);

  public S rename(String oldkey, String newkey);

  public L renamenx(String oldkey, String newkey);

  public S rpop(String key);

  public S rpoplpush(String srckey, String dstkey);

  public L rpush(String key, String string);

  public L rpushx(String key, String string);

  public L sadd(String key, String member);

  public L scard(String key);

  public SS sdiff(String... keys);

  public L sdiffstore(String dstkey, String... keys);

  public S set(String key, String value);

  public B setbit(String key, long offset, boolean value);

  public S setex(String key, int seconds, String value);

  public L setnx(String key, String value);

  public L setrange(String key, long offset, String value);

  public SS sinter(String... keys);

  public L sinterstore(String dstkey, String... keys);

  public B sismember(String key, String member);

  public SS smembers(String key);

  public L smove(String srckey, String dstkey, String member);

  public LS sort(String key);

  public LS sort(String key, SortingParams sortingParameters);

  public LS sort(String key, SortingParams sortingParameters, String dstkey);

  public LS sort(String key, String dstkey);

  public S spop(String key);

  public S srandmember(String key);

  public L srem(String key, String member);

  public L strlen(String key);

  public S substr(String key, int start, int end);

  public SS sunion(String... keys);

  public L sunionstore(String dstkey, String... keys);

  public L ttl(String key);

  public S type(String key);

  public L zadd(String key, double score, String member);

  public L zcard(String key);

  public L zcount(String key, double min, double max);

  public D zincrby(String key, double score, String member);

  public L zinterstore(String dstkey, String... sets);

  public L zinterstore(String dstkey, ZParams params, String... sets);

  public SS zrange(String key, int start, int end);

  public SS zrangeByScore(String key, double min, double max);

  public SS zrangeByScore(String key, String min, String max);

  public SS zrangeByScore(String key, double min, double max, int offset, int count);

  public ST zrangeByScoreWithScores(String key, double min, double max);

  public ST zrangeByScoreWithScores(String key, double min, double max, int offset, int count);

  public ST zrangeWithScores(String key, int start, int end);

  public L zrank(String key, String member);

  public L zrem(String key, String member);

  public L zremrangeByRank(String key, int start, int end);

  public L zremrangeByScore(String key, double start, double end);

  public SS zrevrange(String key, int start, int end);

  public ST zrevrangeWithScores(String key, int start, int end);

  public L zrevrank(String key, String member);

  public D zscore(String key, String member);

  public L zunionstore(String dstkey, String... sets);

  public L zunionstore(String dstkey, ZParams params, String... sets);

  public class NamespaceTransactionImplementation extends Queable implements JedisInterface<Response<Long>, Response<List<String>>, Response<Boolean>, Response<String>, Response<Map<String, String>>, Response<Set<String>>, Response<Set<Tuple>>, Response<Double>>

  {

    private Client client;
    private NamespaceHandler namespace;
    private Transaction transaction;

    public NamespaceTransactionImplementation(Transaction transaction, Client client, NamespaceHandler namespace) {
      this.transaction = transaction;
      this.client = client;
      this.namespace = namespace;
    }

    public NamespaceTransactionImplementation(Transaction transaction, NamespaceHandler namespace) {
      this.transaction = transaction;
      this.namespace = namespace;
    }

    public void setClient(Client client) {
      this.client = client;
    }

    public <T> Response<T> getTransactionResponse(Builder<T> builder) {
      try {
        Method getResponseMethod = Queable.class.getDeclaredMethod("getResponse", Builder.class);
        getResponseMethod.setAccessible(true);
        return (Response<T>) getResponseMethod.invoke(transaction, builder);
      } catch (Exception e) {
        return null;
      }
    }

    public Response<Long> append(String key, String value) {
      client.append(namespace.add(key), value);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<List<String>> blpop(String... args) {
      client.blpop(namespace.add(args));
      return getTransactionResponse(BuilderFactory.STRING_LIST);
    }

    public Response<List<String>> brpop(String... args) {
      client.brpop(namespace.add(args));
      return getTransactionResponse(BuilderFactory.STRING_LIST);
    }

    public Response<Long> decr(String key) {
      client.decr(namespace.add(key));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> decrBy(String key, long integer) {
      client.decrBy(namespace.add(key), integer);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> del(String... keys) {
      client.del(namespace.add(keys));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Boolean> exists(String key) {
      client.exists(namespace.add(key));
      return getTransactionResponse(BuilderFactory.BOOLEAN);
    }

    public Response<Long> expire(String key, int seconds) {
      client.expire(namespace.add(key), seconds);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> expireAt(String key, long unixTime) {
      client.expireAt(namespace.add(key), unixTime);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<String> get(String key) {
      client.get(namespace.add(key));
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Boolean> getbit(String key, long offset) {
      client.getbit(namespace.add(key), offset);
      return getTransactionResponse(BuilderFactory.BOOLEAN);
    }

    public Response<String> getrange(String key, long startOffset,
                                     long endOffset) {
      client.getrange(namespace.add(key), startOffset, endOffset);
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<String> getSet(String key, String value) {
      client.getSet(namespace.add(key), value);
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Long> hdel(String key, String field) {
      client.hdel(namespace.add(key), field);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Boolean> hexists(String key, String field) {
      client.hexists(namespace.add(key), field);
      return getTransactionResponse(BuilderFactory.BOOLEAN);
    }

    public Response<String> hget(String key, String field) {
      client.hget(namespace.add(key), field);
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Map<String, String>> hgetAll(String key) {
      client.hgetAll(namespace.add(key));
      return getTransactionResponse(BuilderFactory.STRING_MAP);
    }

    public Response<Long> hincrBy(String key, String field, long value) {
      client.hincrBy(namespace.add(key), field, value);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Set<String>> hkeys(String key) {
      client.hkeys(namespace.add(key));
      return getTransactionResponse(BuilderFactory.STRING_SET);
    }

    public Response<Long> hlen(String key) {
      client.hlen(namespace.add(key));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<List<String>> hmget(String key, String... fields) {
      client.hmget(namespace.add(key), fields);
      return getTransactionResponse(BuilderFactory.STRING_LIST);
    }

    public Response<String> hmset(String key, Map<String, String> hash) {
      client.hmset(namespace.add(key), hash);
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Long> hset(String key, String field, String value) {
      client.hset(namespace.add(key), field, value);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> hsetnx(String key, String field, String value) {
      client.hsetnx(namespace.add(key), field, value);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<List<String>> hvals(String key) {
      client.hvals(namespace.add(key));
      return getTransactionResponse(BuilderFactory.STRING_LIST);
    }

    public Response<Long> incr(String key) {
      client.incr(namespace.add(key));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> incrBy(String key, long integer) {
      client.incrBy(namespace.add(key), integer);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Set<String>> keys(String pattern) {
      client.keys(namespace.add(pattern));
      return namespace.remove(getTransactionResponse(BuilderFactory.STRING_SET));
    }

    public Response<String> lindex(String key, int index) {
      client.lindex(namespace.add(key), index);
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Long> linsert(String key, BinaryClient.LIST_POSITION where,
                                  String pivot, String value) {
      client.linsert(namespace.add(key), where, pivot, value);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> llen(String key) {
      client.llen(namespace.add(key));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<String> lpop(String key) {
      client.lpop(namespace.add(key));
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Long> lpush(String key, String string) {
      client.lpush(namespace.add(key), string);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> lpushx(String key, String string) {
      client.lpushx(namespace.add(key), string);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<List<String>> lrange(String key, long start, long end) {
      client.lrange(namespace.add(key), start, end);
      return getTransactionResponse(BuilderFactory.STRING_LIST);
    }

    public Response<Long> lrem(String key, long count, String value) {
      client.lrem(namespace.add(key), count, value);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<String> lset(String key, long index, String value) {
      client.lset(namespace.add(key), index, value);
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<String> ltrim(String key, long start, long end) {
      client.ltrim(namespace.add(key), start, end);
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<List<String>> mget(String... keys) {
      client.mget(namespace.add(keys));
      return getTransactionResponse(BuilderFactory.STRING_LIST);
    }

    public Response<Long> move(String key, int dbIndex) {
      client.move(namespace.add(key), dbIndex);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<String> mset(String... keysvalues) {
      client.mset(namespace.addEveryOther(keysvalues));
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Long> msetnx(String... keysvalues) {
      client.msetnx(namespace.addEveryOther(keysvalues));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> persist(String key) {
      client.persist(namespace.add(key));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<String> rename(String oldkey, String newkey) {
      client.rename(namespace.add(oldkey), namespace.add(newkey));
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Long> renamenx(String oldkey, String newkey) {
      client.renamenx(namespace.add(oldkey), namespace.add(newkey));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<String> rpop(String key) {
      client.rpop(namespace.add(key));
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<String> rpoplpush(String srckey, String dstkey) {
      client.rpoplpush(namespace.add(srckey), namespace.add(dstkey));
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Long> rpush(String key, String string) {
      client.rpush(namespace.add(key), string);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> rpushx(String key, String string) {
      client.rpushx(namespace.add(key), string);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> sadd(String key, String member) {
      client.sadd(namespace.add(key), member);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> scard(String key) {
      client.scard(namespace.add(key));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Set<String>> sdiff(String... keys) {
      client.sdiff(namespace.add(keys));
      return getTransactionResponse(BuilderFactory.STRING_SET);
    }

    public Response<Long> sdiffstore(String dstkey, String... keys) {
      client.sdiffstore(namespace.add(dstkey), namespace.add(keys));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<String> set(String key, String value) {
      client.set(namespace.add(key), value);
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Boolean> setbit(String key, long offset, boolean value) {
      client.setbit(namespace.add(key), offset, value);
      return getTransactionResponse(BuilderFactory.BOOLEAN);
    }

    public Response<String> setex(String key, int seconds, String value) {
      client.setex(namespace.add(key), seconds, value);
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Long> setnx(String key, String value) {
      client.setnx(namespace.add(key), value);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> setrange(String key, long offset, String value) {
      client.setrange(namespace.add(key), offset, value);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Set<String>> sinter(String... keys) {
      client.sinter(namespace.add(keys));
      return getTransactionResponse(BuilderFactory.STRING_SET);
    }

    public Response<Long> sinterstore(String dstkey, String... keys) {
      client.sinterstore(namespace.add(dstkey), namespace.add(keys));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Boolean> sismember(String key, String member) {
      client.sismember(namespace.add(key), member);
      return getTransactionResponse(BuilderFactory.BOOLEAN);
    }

    public Response<Set<String>> smembers(String key) {
      client.smembers(namespace.add(key));
      return getTransactionResponse(BuilderFactory.STRING_SET);
    }

    public Response<Long> smove(String srckey, String dstkey, String member) {
      client.smove(namespace.add(srckey), namespace.add(dstkey), member);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<List<String>> sort(String key) {
      client.sort(namespace.add(key));
      return getTransactionResponse(BuilderFactory.STRING_LIST);
    }

    public Response<List<String>> sort(String key,
                                       SortingParams sortingParameters) {
      client.sort(namespace.add(key), namespace.add(sortingParameters));
      return getTransactionResponse(BuilderFactory.STRING_LIST);
    }

    public Response<List<String>> sort(String key,
                                       SortingParams sortingParameters, String dstkey) {
      client.sort(namespace.add(key), namespace.add(sortingParameters), namespace.add(dstkey));
      return getTransactionResponse(BuilderFactory.STRING_LIST);
    }

    public Response<List<String>> sort(String key, String dstkey) {
      client.sort(namespace.add(key), namespace.add(dstkey));
      return getTransactionResponse(BuilderFactory.STRING_LIST);
    }

    public Response<String> spop(String key) {
      client.spop(namespace.add(key));
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<String> srandmember(String key) {
      client.srandmember(namespace.add(key));
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Long> srem(String key, String member) {
      client.srem(namespace.add(key), member);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> strlen(String key) {
      client.strlen(namespace.add(key));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<String> substr(String key, int start, int end) {
      client.substr(namespace.add(key), start, end);
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Set<String>> sunion(String... keys) {
      client.sunion(namespace.add(keys));
      return getTransactionResponse(BuilderFactory.STRING_SET);
    }

    public Response<Long> sunionstore(String dstkey, String... keys) {
      client.sunionstore(namespace.add(dstkey), namespace.add(keys));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> ttl(String key) {
      client.ttl(namespace.add(key));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<String> type(String key) {
      client.type(namespace.add(key));
      return getTransactionResponse(BuilderFactory.STRING);
    }

    public Response<Long> zadd(String key, double score, String member) {
      client.zadd(namespace.add(key), score, member);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> zcard(String key) {
      client.zcard(namespace.add(key));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> zcount(String key, double min, double max) {
      client.zcount(namespace.add(key), min, max);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Double> zincrby(String key, double score, String member) {
      client.zincrby(namespace.add(key), score, member);
      return getTransactionResponse(BuilderFactory.DOUBLE);
    }

    public Response<Long> zinterstore(String dstkey, String... sets) {
      client.zinterstore(namespace.add(dstkey), sets);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> zinterstore(String dstkey, ZParams params,
                                      String... sets) {
      client.zinterstore(namespace.add(dstkey), params, sets);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Set<String>> zrange(String key, int start, int end) {
      client.zrange(namespace.add(key), start, end);
      return getTransactionResponse(BuilderFactory.STRING_ZSET);
    }

    public Response<Set<String>> zrangeByScore(String key, double min,
                                               double max) {
      client.zrangeByScore(namespace.add(key), min, max);
      return getTransactionResponse(BuilderFactory.STRING_ZSET);
    }

    public Response<Set<String>> zrangeByScore(String key, String min,
                                               String max) {
      client.zrangeByScore(namespace.add(key), min, max);
      return getTransactionResponse(BuilderFactory.STRING_ZSET);
    }

    public Response<Set<String>> zrangeByScore(String key, double min,
                                               double max, int offset, int count) {
      client.zrangeByScore(namespace.add(key), min, max, offset, count);
      return getTransactionResponse(BuilderFactory.STRING_ZSET);
    }

    public Response<Set<Tuple>> zrangeByScoreWithScores(String key, double min,
                                                        double max) {
      client.zrangeByScoreWithScores(namespace.add(key), min, max);
      return getTransactionResponse(BuilderFactory.TUPLE_ZSET);
    }

    public Response<Set<Tuple>> zrangeByScoreWithScores(String key, double min,
                                                        double max, int offset, int count) {
      client.zrangeByScoreWithScores(namespace.add(key), min, max, offset, count);
      return getTransactionResponse(BuilderFactory.TUPLE_ZSET);
    }

    public Response<Set<Tuple>> zrangeWithScores(String key, int start, int end) {
      client.zrangeWithScores(namespace.add(key), start, end);
      return getTransactionResponse(BuilderFactory.TUPLE_ZSET);
    }

    public Response<Long> zrank(String key, String member) {
      client.zrank(namespace.add(key), member);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> zrem(String key, String member) {
      client.zrem(namespace.add(key), member);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> zremrangeByRank(String key, int start, int end) {
      client.zremrangeByRank(namespace.add(key), start, end);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> zremrangeByScore(String key, double start, double end) {
      client.zremrangeByScore(namespace.add(key), start, end);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Set<String>> zrevrange(String key, int start, int end) {
      client.zrevrange(namespace.add(key), start, end);
      return getTransactionResponse(BuilderFactory.STRING_ZSET);
    }

    public Response<Set<Tuple>> zrevrangeWithScores(String key, int start,
                                                    int end) {
      client.zrevrangeWithScores(namespace.add(key), start, end);
      return getTransactionResponse(BuilderFactory.TUPLE_ZSET);
    }

    public Response<Long> zrevrank(String key, String member) {
      client.zrevrank(namespace.add(key), member);
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Double> zscore(String key, String member) {
      client.zscore(namespace.add(key), member);
      return getTransactionResponse(BuilderFactory.DOUBLE);
    }

    public Response<Long> zunionstore(String dstkey, String... sets) {
      client.zunionstore(namespace.add(dstkey), namespace.add(sets));
      return getTransactionResponse(BuilderFactory.LONG);
    }

    public Response<Long> zunionstore(String dstkey, ZParams params,
                                      String... sets) {
      client.zunionstore(namespace.add(dstkey), params, namespace.add(sets));
      return getTransactionResponse(BuilderFactory.LONG);
    }

  }

}

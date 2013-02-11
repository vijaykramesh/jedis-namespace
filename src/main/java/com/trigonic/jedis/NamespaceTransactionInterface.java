package com.trigonic.jedis;


import redis.clients.jedis.*;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;


public interface NamespaceTransactionInterface{

// todo generics properly here

  public Response<Long> append(String key, String value);


  public Response<List<String>> blpop(String... args);


  public Response<List<String>> brpop(String... args);


  public Response<Long> decr(String key);


  public Response<Long> decrBy(String key, long integer);


  public Response<Long> del(String... keys);


  public Response<Boolean> exists(String key);


  public Response<Long> expire(String key, int seconds);


  public Response<Long> expireAt(String key, long unixTime);


  public Response<String> get(String key);


  public Response<Boolean> getbit(String key, long offset);


  public Response<String> getrange(String key, long startOffset, long endOffset);


  public Response<String> getSet(String key, String value);


  public Response<Long> hdel(String key, String field);


  public Response<Boolean> hexists(String key, String field);


  public Response<String> hget(String key, String field);


  public Response<Map<String, String>> hgetAll(String key);


  public Response<Long> hincrBy(String key, String field, long value);


  public Response<Set<String>> hkeys(String key);


  public Response<Long> hlen(String key);


  public Response<List<String>> hmget(String key, String... fields);


  public Response<String> hmset(String key, Map<String, String> hash);


  public Response<Long> hset(String key, String field, String value);


  public Response<Long> hsetnx(String key, String field, String value);


  public Response<List<String>> hvals(String key);


  public Response<Long> incr(String key);


  public Response<Long> incrBy(String key, long integer);


  public Response<Set<String>> keys(String pattern);


  public Response<String> lindex(String key, int index);


  public Response<Long> linsert(String key, BinaryClient.LIST_POSITION where, String pivot, String value);


  public Response<Long> llen(String key);


  public Response<String> lpop(String key);


  public Response<Long> lpush(String key, String string);


  public Response<Long> lpushx(String key, String string);


  public Response<List<String>> lrange(String key, long start, long end);


  public Response<Long> lrem(String key, long count, String value);


  public Response<String> lset(String key, long index, String value);


  public Response<String> ltrim(String key, long start, long end);


  public Response<List<String>> mget(String... keys);


  public Response<Long> move(String key, int dbIndex);


  public Response<String> mset(String... keysvalues);


  public Response<Long> msetnx(String... keysvalues);


  public Response<Long> persist(String key);


  public Response<String> rename(String oldkey, String newkey);


  public Response<Long> renamenx(String oldkey, String newkey);


  public Response<String> rpop(String key);


  public Response<String> rpoplpush(String srckey, String dstkey);


  public Response<Long> rpush(String key, String string);


  public Response<Long> rpushx(String key, String string);


  public Response<Long> sadd(String key, String member);


  public Response<Long> scard(String key);


  public Response<Set<String>> sdiff(String... keys);


  public Response<Long> sdiffstore(String dstkey, String... keys);


  public Response<String> set(String key, String value);


  public Response<Boolean> setbit(String key, long offset, boolean value);


  public Response<String> setex(String key, int seconds, String value);


  public Response<Long> setnx(String key, String value);


  public Response<Long> setrange(String key, long offset, String value);


  public Response<Set<String>> sinter(String... keys);


  public Response<Long> sinterstore(String dstkey, String... keys);


  public Response<Boolean> sismember(String key, String member);


  public Response<Set<String>> smembers(String key);


  public Response<Long> smove(String srckey, String dstkey, String member);


  public Response<List<String>> sort(String key);


  public Response<List<String>> sort(String key, SortingParams sortingParameters);


  public Response<List<String>> sort(String key, SortingParams sortingParameters, String dstkey);


  public Response<List<String>> sort(String key, String dstkey);


  public Response<String> spop(String key);


  public Response<String> srandmember(String key);


  public Response<Long> srem(String key, String member);


  public Response<Long> strlen(String key);


  public Response<String> substr(String key, int start, int end);


  public Response<Set<String>> sunion(String... keys);


  public Response<Long> sunionstore(String dstkey, String... keys);


  public Response<Long> ttl(String key);


  public Response<String> type(String key);


  public Response<Long> zadd(String key, double score, String member);


  public Response<Long> zcard(String key);


  public Response<Long> zcount(String key, double min, double max);


  public Response<Double> zincrby(String key, double score, String member);


  public Response<Long> zinterstore(String dstkey, String... sets);


  public Response<Long> zinterstore(String dstkey, ZParams params, String... sets);


  public Response<Set<String>> zrange(String key, int start, int end);


  public Response<Set<String>> zrangeByScore(String key, double min, double max);


  public Response<Set<String>> zrangeByScore(String key, String min, String max);


   public Response<Set<String>> zrangeByScore(String key, double min, double max, int offset, int count);

  public Response<Set<Tuple>> zrangeByScoreWithScores(String key, double min, double max);


  public Response<Set<Tuple>> zrangeByScoreWithScores(String key, double min, double max, int offset, int count);


  public Response<Set<Tuple>> zrangeWithScores(String key, int start, int end);


  public Response<Long> zrank(String key, String member);


  public Response<Long> zrem(String key, String member);


  public Response<Long> zremrangeByRank(String key, int start, int end);


  public Response<Long> zremrangeByScore(String key, double start, double end);


  public Response<Set<String>> zrevrange(String key, int start, int end);


  public Response<Set<Tuple>> zrevrangeWithScores(String key, int start, int end);


  public Response<Long> zrevrank(String key, String member);


  public Response<Double> zscore(String key, String member);


  public Response<Long> zunionstore(String dstkey, String... sets);


  public Response<Long> zunionstore(String dstkey, ZParams params, String... sets);


  public class DefaultNamespaceTransaction extends Queable implements NamespaceTransactionInterface{

    private Client client;
    private NamespaceHandler namespace;
    private Transaction transaction;

    public DefaultNamespaceTransaction(Transaction transaction, Client client, NamespaceHandler namespace){
      this.transaction = transaction;
      this.client = client;
      this.namespace = namespace;
    }

    public DefaultNamespaceTransaction(Transaction transaction, NamespaceHandler namespace){
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
      }catch (Exception e){
        return null;
      }
    }

    public Response<Long> append(String key, String value){
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

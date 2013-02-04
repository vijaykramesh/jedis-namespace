package com.trigonic.jedis;


import redis.clients.jedis.*;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface NamespaceTransactionInterface{

// todo generics properly here

  public Response<Long> append(Client client, NamespaceHandler namespace, String key, String value);


  public Response<List<String>> blpop(Client client, NamespaceHandler namespace, String... args);


  public Response<List<String>> brpop(Client client, NamespaceHandler namespace, String... args);


  public Response<Long> decr(Client client, NamespaceHandler namespace, String key);


  public Response<Long> decrBy(Client client, NamespaceHandler namespace, String key, long integer);


  public Response<Long> del(Client client, NamespaceHandler namespace, String... keys);


  public Response<Boolean> exists(Client client, NamespaceHandler namespace, String key);


  public Response<Long> expire(Client client, NamespaceHandler namespace, String key, int seconds);


  public Response<Long> expireAt(Client client, NamespaceHandler namespace, String key, long unixTime);


  public Response<String> get(Client client, NamespaceHandler namespace, String key);


  public Response<Boolean> getbit(Client client, NamespaceHandler namespace, String key, long offset);


  public Response<String> getrange(Client client, NamespaceHandler namespace, String key, long startOffset, long endOffset);


  public Response<String> getSet(Client client, NamespaceHandler namespace, String key, String value);


  public Response<Long> hdel(Client client, NamespaceHandler namespace, String key, String field);


  public Response<Boolean> hexists(Client client, NamespaceHandler namespace, String key, String field);


  public Response<String> hget(Client client, NamespaceHandler namespace, String key, String field);


  public Response<Map<String, String>> hgetAll(Client client, NamespaceHandler namespace, String key);


  public Response<Long> hincrBy(Client client, NamespaceHandler namespace, String key, String field, long value);


  public Response<Set<String>> hkeys(Client client, NamespaceHandler namespace, String key);


  public Response<Long> hlen(Client client, NamespaceHandler namespace, String key);


  public Response<List<String>> hmget(Client client, NamespaceHandler namespace, String key, String... fields);


  public Response<String> hmset(Client client, NamespaceHandler namespace, String key, Map<String, String> hash);


  public Response<Long> hset(Client client, NamespaceHandler namespace, String key, String field, String value);


  public Response<Long> hsetnx(Client client, NamespaceHandler namespace, String key, String field, String value);


  public Response<List<String>> hvals(Client client, NamespaceHandler namespace, String key);


  public Response<Long> incr(Client client, NamespaceHandler namespace, String key);


  public Response<Long> incrBy(Client client, NamespaceHandler namespace, String key, long integer);


  public Response<Set<String>> keys(Client client, NamespaceHandler namespace, String pattern);


  public Response<String> lindex(Client client, NamespaceHandler namespace, String key, int index);


  public Response<Long> linsert(Client client, NamespaceHandler namespace, String key, BinaryClient.LIST_POSITION where, String pivot, String value);


  public Response<Long> llen(Client client, NamespaceHandler namespace, String key);


  public Response<String> lpop(Client client, NamespaceHandler namespace, String key);


  public Response<Long> lpush(Client client, NamespaceHandler namespace, String key, String string);


  public Response<Long> lpushx(Client client, NamespaceHandler namespace, String key, String string);


  public Response<List<String>> lrange(Client client, NamespaceHandler namespace, String key, long start, long end);


  public Response<Long> lrem(Client client, NamespaceHandler namespace, String key, long count, String value);


  public Response<String> lset(Client client, NamespaceHandler namespace, String key, long index, String value);


  public Response<String> ltrim(Client client, NamespaceHandler namespace, String key, long start, long end);


  public Response<List<String>> mget(Client client, NamespaceHandler namespace, String... keys);


  public Response<Long> move(Client client, NamespaceHandler namespace, String key, int dbIndex);


  public Response<String> mset(Client client, NamespaceHandler namespace, String... keysvalues);


  public Response<Long> msetnx(Client client, NamespaceHandler namespace, String... keysvalues);


  public Response<Long> persist(Client client, NamespaceHandler namespace, String key);


  public Response<String> rename(Client client, NamespaceHandler namespace, String oldkey, String newkey);


  public Response<Long> renamenx(Client client, NamespaceHandler namespace, String oldkey, String newkey);


  public Response<String> rpop(Client client, NamespaceHandler namespace, String key);


  public Response<String> rpoplpush(Client client, NamespaceHandler namespace, String srckey, String dstkey);


  public Response<Long> rpush(Client client, NamespaceHandler namespace, String key, String string);


  public Response<Long> rpushx(Client client, NamespaceHandler namespace, String key, String string);


  public Response<Long> sadd(Client client, NamespaceHandler namespace, String key, String member);


  public Response<Long> scard(Client client, NamespaceHandler namespace, String key);


  public Response<Set<String>> sdiff(Client client, NamespaceHandler namespace, String... keys);


  public Response<Long> sdiffstore(Client client, NamespaceHandler namespace, String dstkey, String... keys);


  public Response<String> set(Client client, NamespaceHandler namespace, String key, String value);


  public Response<Boolean> setbit(Client client, NamespaceHandler namespace, String key, long offset, boolean value);


  public Response<String> setex(Client client, NamespaceHandler namespace, String key, int seconds, String value);


  public Response<Long> setnx(Client client, NamespaceHandler namespace, String key, String value);


  public Response<Long> setrange(Client client, NamespaceHandler namespace, String key, long offset, String value);


  public Response<Set<String>> sinter(Client client, NamespaceHandler namespace, String... keys);


  public Response<Long> sinterstore(Client client, NamespaceHandler namespace, String dstkey, String... keys);


  public Response<Boolean> sismember(Client client, NamespaceHandler namespace, String key, String member);


  public Response<Set<String>> smembers(Client client, NamespaceHandler namespace, String key);


  public Response<Long> smove(Client client, NamespaceHandler namespace, String srckey, String dstkey, String member);


  public Response<List<String>> sort(Client client, NamespaceHandler namespace, String key);


  public Response<List<String>> sort(Client client, NamespaceHandler namespace, String key, SortingParams sortingParameters);


  public Response<List<String>> sort(Client client, NamespaceHandler namespace, String key, SortingParams sortingParameters, String dstkey);


  public Response<List<String>> sort(Client client, NamespaceHandler namespace, String key, String dstkey);


  public Response<String> spop(Client client, NamespaceHandler namespace, String key);


  public Response<String> srandmember(Client client, NamespaceHandler namespace, String key);


  public Response<Long> srem(Client client, NamespaceHandler namespace, String key, String member);


  public Response<Long> strlen(Client client, NamespaceHandler namespace, String key);


  public Response<String> substr(Client client, NamespaceHandler namespace, String key, int start, int end);


  public Response<Set<String>> sunion(Client client, NamespaceHandler namespace, String... keys);


  public Response<Long> sunionstore(Client client, NamespaceHandler namespace, String dstkey, String... keys);


  public Response<Long> ttl(Client client, NamespaceHandler namespace, String key);


  public Response<String> type(Client client, NamespaceHandler namespace, String key);


  public Response<Long> zadd(Client client, NamespaceHandler namespace, String key, double score, String member);


  public Response<Long> zcard(Client client, NamespaceHandler namespace, String key);


  public Response<Long> zcount(Client client, NamespaceHandler namespace, String key, double min, double max);


  public Response<Double> zincrby(Client client, NamespaceHandler namespace, String key, double score, String member);


  public Response<Long> zinterstore(Client client, NamespaceHandler namespace, String dstkey, String... sets);


  public Response<Long> zinterstore(Client client, NamespaceHandler namespace, String dstkey, ZParams params, String... sets);


  public Response<Set<String>> zrange(Client client, NamespaceHandler namespace, String key, int start, int end);


  public Response<Set<String>> zrangeByScore(Client client, NamespaceHandler namespace, String key, double min, double max);


  public Response<Set<String>> zrangeByScore(Client client, NamespaceHandler namespace, String key, String min, String max);


   public Response<Set<String>> zrangeByScore(Client client, NamespaceHandler namespace, String key, double min, double max, int offset, int count);

  public Response<Set<Tuple>> zrangeByScoreWithScores(Client client, NamespaceHandler namespace, String key, double min, double max);


  public Response<Set<Tuple>> zrangeByScoreWithScores(Client client, NamespaceHandler namespace, String key, double min, double max, int offset, int count);


  public Response<Set<Tuple>> zrangeWithScores(Client client, NamespaceHandler namespace, String key, int start, int end);


  public Response<Long> zrank(Client client, NamespaceHandler namespace, String key, String member);


  public Response<Long> zrem(Client client, NamespaceHandler namespace, String key, String member);


  public Response<Long> zremrangeByRank(Client client, NamespaceHandler namespace, String key, int start, int end);


  public Response<Long> zremrangeByScore(Client client, NamespaceHandler namespace, String key, double start, double end);


  public Response<Set<String>> zrevrange(Client client, NamespaceHandler namespace, String key, int start, int end);


  public Response<Set<Tuple>> zrevrangeWithScores(Client client, NamespaceHandler namespace, String key, int start, int end);


  public Response<Long> zrevrank(Client client, NamespaceHandler namespace, String key, String member);


  public Response<Double> zscore(Client client, NamespaceHandler namespace, String key, String member);


  public Response<Long> zunionstore(Client client, NamespaceHandler namespace, String dstkey, String... sets);


  public Response<Long> zunionstore(Client client, NamespaceHandler namespace, String dstkey, ZParams params, String... sets);


  NamespaceTransactionInterface NAMESPACE_TRANSACTION = new DefaultNamespaceTransaction();

  public static class DefaultNamespaceTransaction extends Queable implements NamespaceTransactionInterface{

   public Response<Long> append(Client client, NamespaceHandler namespace, String key, String value) {
     client.append(namespace.add(key), value);
     return getResponse(BuilderFactory.LONG);
   }


   public Response<List<String>> blpop(Client client, NamespaceHandler namespace, String... args) {
     client.blpop(namespace.add(args));
     return getResponse(BuilderFactory.STRING_LIST);
   }


   public Response<List<String>> brpop(Client client, NamespaceHandler namespace, String... args) {
     client.brpop(namespace.add(args));
     return getResponse(BuilderFactory.STRING_LIST);
   }


   public Response<Long> decr(Client client, NamespaceHandler namespace, String key) {
     client.decr(namespace.add(key));
     return getResponse(BuilderFactory.LONG);
   }


    public Response<Long> decrBy(Client client, NamespaceHandler namespace, String key, long integer) {
      client.decrBy(namespace.add(key), integer);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> del(Client client, NamespaceHandler namespace, String... keys) {
      client.del(namespace.add(keys));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Boolean> exists(Client client, NamespaceHandler namespace, String key) {
      client.exists(namespace.add(key));
      return getResponse(BuilderFactory.BOOLEAN);
    }


    public Response<Long> expire(Client client, NamespaceHandler namespace, String key, int seconds) {
      client.expire(namespace.add(key), seconds);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> expireAt(Client client, NamespaceHandler namespace, String key, long unixTime) {
      client.expireAt(namespace.add(key), unixTime);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<String> get(Client client, NamespaceHandler namespace, String key) {
      client.get(namespace.add(key));
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Boolean> getbit(Client client, NamespaceHandler namespace, String key, long offset) {
      client.getbit(namespace.add(key), offset);
      return getResponse(BuilderFactory.BOOLEAN);
    }


    public Response<String> getrange(Client client, NamespaceHandler namespace, String key, long startOffset,
                                     long endOffset) {
      client.getrange(namespace.add(key), startOffset, endOffset);
      return getResponse(BuilderFactory.STRING);
    }


    public Response<String> getSet(Client client, NamespaceHandler namespace, String key, String value) {
      client.getSet(namespace.add(key), value);
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Long> hdel(Client client, NamespaceHandler namespace, String key, String field) {
      client.hdel(namespace.add(key), field);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Boolean> hexists(Client client, NamespaceHandler namespace, String key, String field) {
      client.hexists(namespace.add(key), field);
      return getResponse(BuilderFactory.BOOLEAN);
    }


    public Response<String> hget(Client client, NamespaceHandler namespace, String key, String field) {
      client.hget(namespace.add(key), field);
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Map<String, String>> hgetAll(Client client, NamespaceHandler namespace, String key) {
      client.hgetAll(namespace.add(key));
      return getResponse(BuilderFactory.STRING_MAP);
    }


    public Response<Long> hincrBy(Client client, NamespaceHandler namespace, String key, String field, long value) {
      client.hincrBy(namespace.add(key), field, value);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Set<String>> hkeys(Client client, NamespaceHandler namespace, String key) {
      client.hkeys(namespace.add(key));
      return getResponse(BuilderFactory.STRING_SET);
    }


    public Response<Long> hlen(Client client, NamespaceHandler namespace, String key) {
      client.hlen(namespace.add(key));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<List<String>> hmget(Client client, NamespaceHandler namespace, String key, String... fields) {
      client.hmget(namespace.add(key), fields);
      return getResponse(BuilderFactory.STRING_LIST);
    }


    public Response<String> hmset(Client client, NamespaceHandler namespace, String key, Map<String, String> hash) {
      client.hmset(namespace.add(key), hash);
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Long> hset(Client client, NamespaceHandler namespace, String key, String field, String value) {
      client.hset(namespace.add(key), field, value);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> hsetnx(Client client, NamespaceHandler namespace, String key, String field, String value) {
      client.hsetnx(namespace.add(key), field, value);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<List<String>> hvals(Client client, NamespaceHandler namespace, String key) {
      client.hvals(namespace.add(key));
      return getResponse(BuilderFactory.STRING_LIST);
    }


    public Response<Long> incr(Client client, NamespaceHandler namespace, String key) {
      client.incr(namespace.add(key));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> incrBy(Client client, NamespaceHandler namespace, String key, long integer) {
      client.incrBy(namespace.add(key), integer);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Set<String>> keys(Client client, NamespaceHandler namespace, String pattern) {
      client.keys(namespace.add(pattern));
      return namespace.remove(getResponse(BuilderFactory.STRING_SET));
    }


    public Response<String> lindex(Client client, NamespaceHandler namespace, String key, int index) {
      client.lindex(namespace.add(key), index);
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Long> linsert(Client client, NamespaceHandler namespace, String key, BinaryClient.LIST_POSITION where,
                                  String pivot, String value) {
      client.linsert(namespace.add(key), where, pivot, value);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> llen(Client client, NamespaceHandler namespace, String key) {
      client.llen(namespace.add(key));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<String> lpop(Client client, NamespaceHandler namespace, String key) {
      client.lpop(namespace.add(key));
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Long> lpush(Client client, NamespaceHandler namespace, String key, String string) {
      client.lpush(namespace.add(key), string);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> lpushx(Client client, NamespaceHandler namespace, String key, String string) {
      client.lpushx(namespace.add(key), string);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<List<String>> lrange(Client client, NamespaceHandler namespace, String key, long start, long end) {
      client.lrange(namespace.add(key), start, end);
      return getResponse(BuilderFactory.STRING_LIST);
    }


    public Response<Long> lrem(Client client, NamespaceHandler namespace, String key, long count, String value) {
      client.lrem(namespace.add(key), count, value);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<String> lset(Client client, NamespaceHandler namespace, String key, long index, String value) {
      client.lset(namespace.add(key), index, value);
      return getResponse(BuilderFactory.STRING);
    }


    public Response<String> ltrim(Client client, NamespaceHandler namespace, String key, long start, long end) {
      client.ltrim(namespace.add(key), start, end);
      return getResponse(BuilderFactory.STRING);
    }


    public Response<List<String>> mget(Client client, NamespaceHandler namespace, String... keys) {
      client.mget(namespace.add(keys));
      return getResponse(BuilderFactory.STRING_LIST);
    }


    public Response<Long> move(Client client, NamespaceHandler namespace, String key, int dbIndex) {
      client.move(namespace.add(key), dbIndex);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<String> mset(Client client, NamespaceHandler namespace, String... keysvalues) {
      client.mset(namespace.addEveryOther(keysvalues));
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Long> msetnx(Client client, NamespaceHandler namespace, String... keysvalues) {
      client.msetnx(namespace.addEveryOther(keysvalues));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> persist(Client client, NamespaceHandler namespace, String key) {
      client.persist(namespace.add(key));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<String> rename(Client client, NamespaceHandler namespace, String oldkey, String newkey) {
      client.rename(namespace.add(oldkey), namespace.add(newkey));
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Long> renamenx(Client client, NamespaceHandler namespace, String oldkey, String newkey) {
      client.renamenx(namespace.add(oldkey), namespace.add(newkey));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<String> rpop(Client client, NamespaceHandler namespace, String key) {
      client.rpop(namespace.add(key));
      return getResponse(BuilderFactory.STRING);
    }


    public Response<String> rpoplpush(Client client, NamespaceHandler namespace, String srckey, String dstkey) {
      client.rpoplpush(namespace.add(srckey), namespace.add(dstkey));
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Long> rpush(Client client, NamespaceHandler namespace, String key, String string) {
      client.rpush(namespace.add(key), string);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> rpushx(Client client, NamespaceHandler namespace, String key, String string) {
      client.rpushx(namespace.add(key), string);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> sadd(Client client, NamespaceHandler namespace, String key, String member) {
      client.sadd(namespace.add(key), member);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> scard(Client client, NamespaceHandler namespace, String key) {
      client.scard(namespace.add(key));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Set<String>> sdiff(Client client, NamespaceHandler namespace, String... keys) {
      client.sdiff(namespace.add(keys));
      return getResponse(BuilderFactory.STRING_SET);
    }


    public Response<Long> sdiffstore(Client client, NamespaceHandler namespace, String dstkey, String... keys) {
      client.sdiffstore(namespace.add(dstkey), namespace.add(keys));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<String> set(Client client, NamespaceHandler namespace, String key, String value) {
      client.set(namespace.add(key), value);
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Boolean> setbit(Client client, NamespaceHandler namespace, String key, long offset, boolean value) {
      client.setbit(namespace.add(key), offset, value);
      return getResponse(BuilderFactory.BOOLEAN);
    }


    public Response<String> setex(Client client, NamespaceHandler namespace, String key, int seconds, String value) {
      client.setex(namespace.add(key), seconds, value);
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Long> setnx(Client client, NamespaceHandler namespace, String key, String value) {
      client.setnx(namespace.add(key), value);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> setrange(Client client, NamespaceHandler namespace, String key, long offset, String value) {
      client.setrange(namespace.add(key), offset, value);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Set<String>> sinter(Client client, NamespaceHandler namespace, String... keys) {
      client.sinter(namespace.add(keys));
      return getResponse(BuilderFactory.STRING_SET);
    }


    public Response<Long> sinterstore(Client client, NamespaceHandler namespace, String dstkey, String... keys) {
      client.sinterstore(namespace.add(dstkey), namespace.add(keys));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Boolean> sismember(Client client, NamespaceHandler namespace, String key, String member) {
      client.sismember(namespace.add(key), member);
      return getResponse(BuilderFactory.BOOLEAN);
    }


    public Response<Set<String>> smembers(Client client, NamespaceHandler namespace, String key) {
      client.smembers(namespace.add(key));
      return getResponse(BuilderFactory.STRING_SET);
    }


    public Response<Long> smove(Client client, NamespaceHandler namespace, String srckey, String dstkey, String member) {
      client.smove(namespace.add(srckey), namespace.add(dstkey), member);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<List<String>> sort(Client client, NamespaceHandler namespace, String key) {
      client.sort(namespace.add(key));
      return getResponse(BuilderFactory.STRING_LIST);
    }


    public Response<List<String>> sort(Client client, NamespaceHandler namespace, String key,
                                       SortingParams sortingParameters) {
      client.sort(namespace.add(key), namespace.add(sortingParameters));
      return getResponse(BuilderFactory.STRING_LIST);
    }


    public Response<List<String>> sort(Client client, NamespaceHandler namespace, String key,
                                       SortingParams sortingParameters, String dstkey) {
      client.sort(namespace.add(key), namespace.add(sortingParameters), namespace.add(dstkey));
      return getResponse(BuilderFactory.STRING_LIST);
    }


    public Response<List<String>> sort(Client client, NamespaceHandler namespace, String key, String dstkey) {
      client.sort(namespace.add(key), namespace.add(dstkey));
      return getResponse(BuilderFactory.STRING_LIST);
    }


    public Response<String> spop(Client client, NamespaceHandler namespace, String key) {
      client.spop(namespace.add(key));
      return getResponse(BuilderFactory.STRING);
    }


    public Response<String> srandmember(Client client, NamespaceHandler namespace, String key) {
      client.srandmember(namespace.add(key));
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Long> srem(Client client, NamespaceHandler namespace, String key, String member) {
      client.srem(namespace.add(key), member);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> strlen(Client client, NamespaceHandler namespace, String key) {
      client.strlen(namespace.add(key));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<String> substr(Client client, NamespaceHandler namespace, String key, int start, int end) {
      client.substr(namespace.add(key), start, end);
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Set<String>> sunion(Client client, NamespaceHandler namespace, String... keys) {
      client.sunion(namespace.add(keys));
      return getResponse(BuilderFactory.STRING_SET);
    }


    public Response<Long> sunionstore(Client client, NamespaceHandler namespace, String dstkey, String... keys) {
      client.sunionstore(namespace.add(dstkey), namespace.add(keys));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> ttl(Client client, NamespaceHandler namespace, String key) {
      client.ttl(namespace.add(key));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<String> type(Client client, NamespaceHandler namespace, String key) {
      client.type(namespace.add(key));
      return getResponse(BuilderFactory.STRING);
    }


    public Response<Long> zadd(Client client, NamespaceHandler namespace, String key, double score, String member) {
      client.zadd(namespace.add(key), score, member);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> zcard(Client client, NamespaceHandler namespace, String key) {
      client.zcard(namespace.add(key));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> zcount(Client client, NamespaceHandler namespace, String key, double min, double max) {
      client.zcount(namespace.add(key), min, max);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Double> zincrby(Client client, NamespaceHandler namespace, String key, double score, String member) {
      client.zincrby(namespace.add(key), score, member);
      return getResponse(BuilderFactory.DOUBLE);
    }


    public Response<Long> zinterstore(Client client, NamespaceHandler namespace, String dstkey, String... sets) {
      client.zinterstore(namespace.add(dstkey), sets);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> zinterstore(Client client, NamespaceHandler namespace, String dstkey, ZParams params,
                                      String... sets) {
      client.zinterstore(namespace.add(dstkey), params, sets);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Set<String>> zrange(Client client, NamespaceHandler namespace, String key, int start, int end) {
      client.zrange(namespace.add(key), start, end);
      return getResponse(BuilderFactory.STRING_ZSET);
    }


    public Response<Set<String>> zrangeByScore(Client client, NamespaceHandler namespace, String key, double min,
                                               double max) {
      client.zrangeByScore(namespace.add(key), min, max);
      return getResponse(BuilderFactory.STRING_ZSET);
    }


    public Response<Set<String>> zrangeByScore(Client client, NamespaceHandler namespace, String key, String min,
                                               String max) {
      client.zrangeByScore(namespace.add(key), min, max);
      return getResponse(BuilderFactory.STRING_ZSET);
    }


    public Response<Set<String>> zrangeByScore(Client client, NamespaceHandler namespace, String key, double min,
                                               double max, int offset, int count) {
      client.zrangeByScore(namespace.add(key), min, max, offset, count);
      return getResponse(BuilderFactory.STRING_ZSET);
    }


    public Response<Set<Tuple>> zrangeByScoreWithScores(Client client, NamespaceHandler namespace, String key, double min,
                                                        double max) {
      client.zrangeByScoreWithScores(namespace.add(key), min, max);
      return getResponse(BuilderFactory.TUPLE_ZSET);
    }


    public Response<Set<Tuple>> zrangeByScoreWithScores(Client client, NamespaceHandler namespace, String key, double min,
                                                        double max, int offset, int count) {
      client.zrangeByScoreWithScores(namespace.add(key), min, max, offset, count);
      return getResponse(BuilderFactory.TUPLE_ZSET);
    }


    public Response<Set<Tuple>> zrangeWithScores(Client client, NamespaceHandler namespace, String key, int start, int end) {
      client.zrangeWithScores(namespace.add(key), start, end);
      return getResponse(BuilderFactory.TUPLE_ZSET);
    }


    public Response<Long> zrank(Client client, NamespaceHandler namespace, String key, String member) {
      client.zrank(namespace.add(key), member);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> zrem(Client client, NamespaceHandler namespace, String key, String member) {
      client.zrem(namespace.add(key), member);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> zremrangeByRank(Client client, NamespaceHandler namespace, String key, int start, int end) {
      client.zremrangeByRank(namespace.add(key), start, end);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> zremrangeByScore(Client client, NamespaceHandler namespace, String key, double start, double end) {
      client.zremrangeByScore(namespace.add(key), start, end);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Set<String>> zrevrange(Client client, NamespaceHandler namespace, String key, int start, int end) {
      client.zrevrange(namespace.add(key), start, end);
      return getResponse(BuilderFactory.STRING_ZSET);
    }


    public Response<Set<Tuple>> zrevrangeWithScores(Client client, NamespaceHandler namespace, String key, int start,
                                                    int end) {
      client.zrevrangeWithScores(namespace.add(key), start, end);
      return getResponse(BuilderFactory.TUPLE_ZSET);
    }


    public Response<Long> zrevrank(Client client, NamespaceHandler namespace, String key, String member) {
      client.zrevrank(namespace.add(key), member);
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Double> zscore(Client client, NamespaceHandler namespace, String key, String member) {
      client.zscore(namespace.add(key), member);
      return getResponse(BuilderFactory.DOUBLE);
    }


    public Response<Long> zunionstore(Client client, NamespaceHandler namespace, String dstkey, String... sets) {
      client.zunionstore(namespace.add(dstkey), namespace.add(sets));
      return getResponse(BuilderFactory.LONG);
    }


    public Response<Long> zunionstore(Client client, NamespaceHandler namespace, String dstkey, ZParams params,
                                      String... sets) {
      client.zunionstore(namespace.add(dstkey), params, namespace.add(sets));
      return getResponse(BuilderFactory.LONG);
    }


  }

}

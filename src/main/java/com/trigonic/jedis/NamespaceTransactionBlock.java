package com.trigonic.jedis;

import redis.clients.jedis.*;
import redis.clients.jedis.exceptions.JedisException;

import java.util.List;
import java.util.Map;
import java.util.Set;


public abstract class NamespaceTransactionBlock extends TransactionBlock{
  public NamespaceTransactionBlock( NamespaceHandler namespace, Client client) {
    super(client);
    this.defaultNamespaceTransaction = new NamespaceTransactionInterface.DefaultNamespaceTransaction(this, client, namespace);

  }


  public abstract void execute() throws JedisException;

  public void setClient(Client client) {

    this.client = client;
  }


  private NamespaceTransactionInterface.DefaultNamespaceTransaction defaultNamespaceTransaction;


  // NamespaceTransactionInterface uses this to pass on getReponse to the right Queuable instance
  // TODO replace with reflection, but not currently working.
  public <T> Response<T> getTResponse(Builder<T> builder) {
    return getResponse(builder);
  }

  @Override
  public Response<Long> append(String key, String value) {
    return defaultNamespaceTransaction.append(key, value);
  }

  @Override
  public Response<List<String>> blpop(String... args) {
    return defaultNamespaceTransaction.blpop(args);
  }

  @Override
  public Response<List<String>> brpop(String... args) {
    return defaultNamespaceTransaction.brpop(args);
  }

  @Override
  public Response<Long> decr(String key) {
    return defaultNamespaceTransaction.decr(key);
  }

  @Override
  public Response<Long> decrBy(String key, long integer) {
    return defaultNamespaceTransaction.decrBy(key, integer);
  }

  @Override
  public Response<Long> del(String... keys) {
    return defaultNamespaceTransaction.del(keys);
  }

  @Override
  public Response<Boolean> exists(String key) {
    return defaultNamespaceTransaction.exists(key);
  }

  @Override
  public Response<Long> expire(String key, int seconds) {
    return defaultNamespaceTransaction.expire(key, seconds);
  }

  @Override
  public Response<Long> expireAt(String key, long unixTime) {
    return defaultNamespaceTransaction.expireAt(key, unixTime);
  }

  @Override
  public Response<String> get(String key) {
    return defaultNamespaceTransaction.get(key);
  }

  @Override
  public Response<Boolean> getbit(String key, long offset) {
    return defaultNamespaceTransaction.getbit(key, offset);
  }

  @Override
  public Response<String> getrange(String key, long startOffset,
                                   long endOffset) {
    return defaultNamespaceTransaction.getrange(key, startOffset, endOffset);
  }

  @Override
  public Response<String> getSet(String key, String value) {
    return defaultNamespaceTransaction.getSet(key, value);
  }

  @Override
  public Response<Long> hdel(String key, String field) {
    return defaultNamespaceTransaction.hdel(key, field);
  }

  @Override
  public Response<Boolean> hexists(String key, String field) {
    return defaultNamespaceTransaction.hexists(key, field);
  }

  @Override
  public Response<String> hget(String key, String field) {
    return defaultNamespaceTransaction.hget(key, field);
  }

  @Override
  public Response<Map<String, String>> hgetAll(String key) {
    return defaultNamespaceTransaction.hgetAll(key);
  }

  @Override
  public Response<Long> hincrBy(String key, String field, long value) {
    return defaultNamespaceTransaction.hincrBy(key, field, value);
  }

  @Override
  public Response<Set<String>> hkeys(String key) {
    return defaultNamespaceTransaction.hkeys(key);
  }

  @Override
  public Response<Long> hlen(String key) {
    return defaultNamespaceTransaction.hlen(key);
  }

  @Override
  public Response<List<String>> hmget(String key, String... fields) {
    return defaultNamespaceTransaction.hmget(key, fields);
  }

  @Override
  public Response<String> hmset(String key, Map<String, String> hash) {
    return defaultNamespaceTransaction.hmset(key, hash);
  }

  @Override
  public Response<Long> hset(String key, String field, String value) {
    return defaultNamespaceTransaction.hset(key, field, value);
  }

  @Override
  public Response<Long> hsetnx(String key, String field, String value) {
    return defaultNamespaceTransaction.hsetnx(key, field, value);
  }

  @Override
  public Response<List<String>> hvals(String key) {
    return defaultNamespaceTransaction.hvals(key);
  }

  @Override
  public Response<Long> incr(String key) {
    return defaultNamespaceTransaction.incr(key);
  }

  @Override
  public Response<Long> incrBy(String key, long integer) {
    return defaultNamespaceTransaction.incrBy(key, integer);
  }

  @Override
  public Response<Set<String>> keys(String pattern) {
    return defaultNamespaceTransaction.keys(pattern);
  }

  @Override
  public Response<String> lindex(String key, int index) {
    return defaultNamespaceTransaction.lindex(key, index);
  }

  @Override
  public Response<Long> linsert(String key, BinaryClient.LIST_POSITION where,
                                String pivot, String value) {
    return defaultNamespaceTransaction.linsert(key, where, pivot, value);
  }

  @Override
  public Response<Long> llen(String key) {
    return defaultNamespaceTransaction.llen(key);
  }

  @Override
  public Response<String> lpop(String key) {
    return defaultNamespaceTransaction.lpop(key);
  }

  @Override
  public Response<Long> lpush(String key, String string) {
    return defaultNamespaceTransaction.lpush(key, string);
  }

  @Override
  public Response<Long> lpushx(String key, String string) {
    return defaultNamespaceTransaction.lpushx(key, string);
  }

  @Override
  public Response<List<String>> lrange(String key, long start, long end) {
    return defaultNamespaceTransaction.lrange(key, start, end);
  }

  @Override
  public Response<Long> lrem(String key, long count, String value) {
    return defaultNamespaceTransaction.lrem(key, count, value);
  }

  @Override
  public Response<String> lset(String key, long index, String value) {
    return defaultNamespaceTransaction.lset(key, index, value);
  }

  @Override
  public Response<String> ltrim(String key, long start, long end) {
    return defaultNamespaceTransaction.ltrim(key, start, end);
  }

  @Override
  public Response<List<String>> mget(String... keys) {
    return defaultNamespaceTransaction.mget(keys);
  }

  @Override
  public Response<Long> move(String key, int dbIndex) {
    return defaultNamespaceTransaction.move(key, dbIndex);
  }

  @Override
  public Response<String> mset(String... keysvalues) {
    return defaultNamespaceTransaction.mset(keysvalues);
  }

  @Override
  public Response<Long> msetnx(String... keysvalues) {
    return defaultNamespaceTransaction.msetnx(keysvalues);
  }

  @Override
  public Response<Long> persist(String key) {
    return defaultNamespaceTransaction.persist(key);
  }

  @Override
  public Response<String> rename(String oldkey, String newkey) {
    return defaultNamespaceTransaction.rename(oldkey, newkey);
  }

  @Override
  public Response<Long> renamenx(String oldkey, String newkey) {
    return defaultNamespaceTransaction.renamenx(oldkey, newkey);
  }

  @Override
  public Response<String> rpop(String key) {
    return defaultNamespaceTransaction.rpop(key);
  }

  @Override
  public Response<String> rpoplpush(String srckey, String dstkey) {
    return defaultNamespaceTransaction.rpoplpush(srckey, dstkey);
  }

  @Override
  public Response<Long> rpush(String key, String string) {
    return defaultNamespaceTransaction.rpush(key, string);
  }

  @Override
  public Response<Long> rpushx(String key, String string) {
    return defaultNamespaceTransaction.rpushx(key, string);
  }

  @Override
  public Response<Long> sadd(String key, String member) {
    return defaultNamespaceTransaction.sadd(key, member);
  }

  @Override
  public Response<Long> scard(String key) {
    return defaultNamespaceTransaction.scard(key);
  }

  @Override
  public Response<Set<String>> sdiff(String... keys) {
    return defaultNamespaceTransaction.sdiff(keys);
  }

  @Override
  public Response<Long> sdiffstore(String dstkey, String... keys) {
    return defaultNamespaceTransaction.sdiffstore(dstkey, keys);
  }

  @Override
  public Response<String> set(String key, String value) {
    return defaultNamespaceTransaction.set(key, value);
  }

  @Override
  public Response<Boolean> setbit(String key, long offset, boolean value) {
    return defaultNamespaceTransaction.setbit(key, offset, value);
  }

  @Override
  public Response<String> setex(String key, int seconds, String value) {
    return defaultNamespaceTransaction.setex(key, seconds, value);
  }

  @Override
  public Response<Long> setnx(String key, String value) {
    return defaultNamespaceTransaction.setnx(key, value);
  }

  @Override
  public Response<Long> setrange(String key, long offset, String value) {
    return defaultNamespaceTransaction.setrange(key, offset, value);
  }

  @Override
  public Response<Set<String>> sinter(String... keys) {
    return defaultNamespaceTransaction.sinter(keys);
  }

  @Override
  public Response<Long> sinterstore(String dstkey, String... keys) {
    return defaultNamespaceTransaction.sinterstore(dstkey, keys);
  }

  @Override
  public Response<Boolean> sismember(String key, String member) {
    return defaultNamespaceTransaction.sismember(key, member);
  }

  @Override
  public Response<Set<String>> smembers(String key) {
    return defaultNamespaceTransaction.smembers(key);
  }

  @Override
  public Response<Long> smove(String srckey, String dstkey, String member) {
    return defaultNamespaceTransaction.smove(srckey, dstkey, member);
  }

  @Override
  public Response<List<String>> sort(String key) {
    return defaultNamespaceTransaction.sort(key);
  }

  @Override
  public Response<List<String>> sort(String key,
                                     SortingParams sortingParameters) {
    return defaultNamespaceTransaction.sort(key, sortingParameters);
  }

  @Override
  public Response<List<String>> sort(String key,
                                     SortingParams sortingParameters, String dstkey) {
    return defaultNamespaceTransaction.sort(key, sortingParameters, dstkey);
  }

  @Override
  public Response<List<String>> sort(String key, String dstkey) {
    return defaultNamespaceTransaction.sort(key, dstkey);
  }

  @Override
  public Response<String> spop(String key) {
    return defaultNamespaceTransaction.spop(key);
  }

  @Override
  public Response<String> srandmember(String key) {
    return defaultNamespaceTransaction.srandmember(key);
  }

  @Override
  public Response<Long> srem(String key, String member) {
    return defaultNamespaceTransaction.srem(key, member);
  }

  @Override
  public Response<Long> strlen(String key) {
    return defaultNamespaceTransaction.strlen(key);
  }

  @Override
  public Response<String> substr(String key, int start, int end) {
    return defaultNamespaceTransaction.substr(key, start, end);
  }

  @Override
  public Response<Set<String>> sunion(String... keys) {
    return defaultNamespaceTransaction.sunion(keys);
  }

  @Override
  public Response<Long> sunionstore(String dstkey, String... keys) {
    return defaultNamespaceTransaction.sunionstore(dstkey, keys);
  }

  @Override
  public Response<Long> ttl(String key) {
    return defaultNamespaceTransaction.ttl(key);
  }

  @Override
  public Response<String> type(String key) {
    return defaultNamespaceTransaction.type(key);
  }

  @Override
  public Response<Long> zadd(String key, double score, String member) {
    return defaultNamespaceTransaction.zadd(key, score, member);
  }

  @Override
  public Response<Long> zcard(String key) {
    return defaultNamespaceTransaction.zcard(key);
  }

  @Override
  public Response<Long> zcount(String key, double min, double max) {
    return defaultNamespaceTransaction.zcount(key, min, max);
  }

  @Override
  public Response<Double> zincrby(String key, double score, String member) {
    return defaultNamespaceTransaction.zincrby(key, score, member);
  }

  @Override
  public Response<Long> zinterstore(String dstkey, String... sets) {
    return defaultNamespaceTransaction.zinterstore(dstkey, sets);
  }

  @Override
  public Response<Long> zinterstore(String dstkey, ZParams params,
                                    String... sets) {
    return defaultNamespaceTransaction.zinterstore(dstkey, params, sets);
  }

  @Override
  public Response<Set<String>> zrange(String key, int start, int end) {
    return defaultNamespaceTransaction.zrange(key, start, end);
  }

  @Override
  public Response<Set<String>> zrangeByScore(String key, double min,
                                             double max) {
    return defaultNamespaceTransaction.zrangeByScore(key, min, max);
  }

  @Override
  public Response<Set<String>> zrangeByScore(String key, String min,
                                             String max) {
    return defaultNamespaceTransaction.zrangeByScore(key, min, max);
  }

  @Override
  public Response<Set<String>> zrangeByScore(String key, double min,
                                             double max, int offset, int count) {
    return defaultNamespaceTransaction.zrangeByScore(key, min, max, offset, count);
  }

  @Override
  public Response<Set<Tuple>> zrangeByScoreWithScores(String key, double min,
                                                      double max) {
    return defaultNamespaceTransaction.zrangeByScoreWithScores(key, min, max);
  }

  @Override
  public Response<Set<Tuple>> zrangeByScoreWithScores(String key, double min,
                                                      double max, int offset, int count) {
    return defaultNamespaceTransaction.zrangeByScoreWithScores(key, min, max, offset, count);
  }

  @Override
  public Response<Set<Tuple>> zrangeWithScores(String key, int start, int end) {
    return defaultNamespaceTransaction.zrangeWithScores(key, start, end);
  }

  @Override
  public Response<Long> zrank(String key, String member) {
    return defaultNamespaceTransaction.zrank(key, member);
  }

  @Override
  public Response<Long> zrem(String key, String member) {
    return defaultNamespaceTransaction.zrem(key, member);
  }

  @Override
  public Response<Long> zremrangeByRank(String key, int start, int end) {
    return defaultNamespaceTransaction.zremrangeByRank(key, start, end);
  }

  @Override
  public Response<Long> zremrangeByScore(String key, double start, double end) {
    return defaultNamespaceTransaction.zremrangeByScore(key, start, end);
  }

  @Override
  public Response<Set<String>> zrevrange(String key, int start, int end) {
    return defaultNamespaceTransaction.zrevrange(key, start, end);
  }

  @Override
  public Response<Set<Tuple>> zrevrangeWithScores(String key, int start,
                                                  int end) {
    return defaultNamespaceTransaction.zrevrangeWithScores(key, start, end);
  }

  @Override
  public Response<Long> zrevrank(String key, String member) {
    return defaultNamespaceTransaction.zrevrank(key, member);
  }

  @Override
  public Response<Double> zscore(String key, String member) {
    return defaultNamespaceTransaction.zscore(key, member);
  }

  @Override
  public Response<Long> zunionstore(String dstkey, String... sets) {
    return defaultNamespaceTransaction.zunionstore(dstkey, sets);
  }

  @Override
  public Response<Long> zunionstore(String dstkey, ZParams params,
                                    String... sets) {
    return defaultNamespaceTransaction.zunionstore(dstkey, params, sets);
  }
}

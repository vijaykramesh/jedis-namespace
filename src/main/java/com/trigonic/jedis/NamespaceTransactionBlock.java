package com.trigonic.jedis;

import redis.clients.jedis.Client;
import redis.clients.jedis.TransactionBlock;
import redis.clients.jedis.exceptions.JedisException;


public abstract class NamespaceTransactionBlock extends TransactionBlock{
  public NamespaceTransactionBlock( NamespaceHandler namespace, Client client) {
    super(client);
  }
  public NamespaceTransactionBlock( NamespaceHandler namespace) {
    super();
  }
  public abstract void execute() throws JedisException;

  public void setClient(Client client) {

    this.client = client;
  }
}

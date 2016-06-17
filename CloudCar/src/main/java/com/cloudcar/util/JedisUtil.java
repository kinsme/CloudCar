package com.cloudcar.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Administrator on 2016/6/17.
 */
public class JedisUtil {
    private static String Host="localhost";
    private static int PORT=6379;
    private static int MAX_ACTIVE=20;
    private static int MAX_IDLE=8;
    private static int MAX_WAIT=10000;
    private static int TIMEOUT=10000;
    private static JedisPool jedisPool=null;
    static {
        JedisPoolConfig config=new JedisPoolConfig();
        config.setMaxIdle(MAX_IDLE);
        config.setMaxTotal(MAX_ACTIVE);
        config.setMaxWaitMillis(MAX_WAIT);
        jedisPool=new JedisPool(config,Host,PORT,TIMEOUT);
    }
    public synchronized static Jedis getJedis(){
        if (jedisPool!=null){
            Jedis jedis=jedisPool.getResource();
            return jedis;
        }else {
            return null;
        }
    }
    public static void removeResource(final Jedis jedis){
        if (jedis!=null){
           jedisPool.returnResource(jedis);
        }
    }
}

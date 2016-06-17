package com.cloudcar.DAO;

import com.cloudcar.util.JedisUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2016/6/17.
 */
public class RedisOnlineDAOImpl implements IOnlineDAO{
    public boolean findBySerialnumber(String serialnumber) {
        //Jedis jedis=new Jedis("localhost",6379);
        Jedis jedis=null;
        try{
            jedis= JedisUtil.getJedis();
            String online=jedis.get(serialnumber);
            if (online!=null){
                return true;
            }else{
                return false;
            }
        }finally {
            JedisUtil.removeResource(jedis);
        }

    }

    public void setOnline(String serialnumber) {
        //Jedis jedis=new Jedis("localhost",6379);
        Jedis jedis=null;
        try {
            jedis= JedisUtil.getJedis();
            jedis.set(serialnumber,"");
        }finally {
            JedisUtil.removeResource(jedis);
        }

    }

    public void setOffline(String serialnumber) {
        //Jedis jedis=new Jedis("localhost",6379);
        Jedis jedis=null;
        try{
            jedis= JedisUtil.getJedis();
            jedis.del(serialnumber);
            //持久化数据
        }finally {
            JedisUtil.removeResource(jedis);
        }

    }

}

package com.atguigu.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Test01 {

    Jedis jedisConn = null;

    @Before
    public void init(){
        System.out.println("jedis connection init");
        jedisConn = new Jedis("hadoop102",6379);
    }

    @After
    public void stop(){
        System.out.println("jedis connection close");
        jedisConn.close();
    }

    @Test
    public void test(){
        System.out.println(jedisConn.ping());
        jedisConn.set("hello","world");
        System.out.println(jedisConn.get("hello"));
    }
    @Test
    public void test01(){

    }
}

package com.example.person.utils.redis;

import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RedisUtil   {
    private static Jedis redis = null;

    static {
        redis =  RedisResouce.getJedis();
        System.out.println("Connection to server sucessfully");
    }
    public static void setStrKeyVal(String key ,String value ){
        redis.set(key,value);
    }
    public static String getStrByKey(String key ){
           return redis.get(key);
    }

    public static Long del(String... keys) {
           return redis.del(keys);
    }
    // 键值增加字符
    public static Long append(String key, String str) {
        return redis.append(key, str);
    }
    public static String setStrKeyValTime(String key, String value, int seconds) {
        return redis.setex(key, seconds, value);
    }
    //存储数据到列表中
    public static void setStrArr(String key ,String[] values) {
        redis.lpush(key, values);
        // List<String> list = redis.lrange("site-list", 0 ,2);
    }

    //获取所有的Key
    public static List<String> getAllKeys() {
        List<String> keyList =new ArrayList<>();
        Set<String> keys = redis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            keyList.add( it.next());
        }
        return keyList;
    }


}

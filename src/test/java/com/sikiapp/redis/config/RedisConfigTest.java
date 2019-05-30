package com.sikiapp.redis.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void initRedisTemplate() {
        redisTemplate.opsForValue().setIfAbsent("k1", "v1");
        Object v1 = redisTemplate.opsForValue().get("k1");
        redisTemplate.opsForHash().put("hash", "field", "hvalue");
        System.out.println(v1);
    }

    @Test
    public void multiOpts() {
        redisTemplate.execute(new SessionCallback<Object>() {
            @Override
            public Object execute(RedisOperations ro) throws DataAccessException {
                ro.opsForValue().setIfAbsent("k2", "v2");
                ro.opsForHash().put("hash1", "field1", "hvalue1");
                return null;
            }
        });
    }

    @Test
    public void multiOpsHash() {
        stringRedisTemplate.opsForValue().set("int", "1");
        stringRedisTemplate.opsForValue().increment("int", 1);
        System.out.println(stringRedisTemplate.opsForValue().get("int"));

        Jedis jedis = (Jedis)stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        jedis.decr("int");
        System.out.println(stringRedisTemplate.opsForValue().get("int"));

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("field1", "value1");
        hashMap.put("field2", "value2");
        stringRedisTemplate.opsForHash().putAll("hash", hashMap);
        System.out.println(stringRedisTemplate.opsForHash().get("hash", "field1"));

        stringRedisTemplate.opsForHash().put("hash", "field3", "value3");
        System.out.println(stringRedisTemplate.opsForHash().get("hash", "field1"));

        BoundHashOperations hashOps = stringRedisTemplate.boundHashOps("hash");
        hashOps.delete("field1", "field2");
        hashOps.put("field4", "value4");
    }

    @Test
    public void multiOpsSet() {
        stringRedisTemplate.opsForSet().add("set1", "v1", "v1", "v2", "v3", "v4", "v5");
        stringRedisTemplate.opsForSet().add("set2", "v2", "v4", "v6", "v8");

        BoundSetOperations<String, String> setOps = stringRedisTemplate.boundSetOps("set1");
        setOps.add("v6", "v7");
        setOps.remove("v1", "v7");
        Set<String> members = setOps.members();
        Long size = setOps.size();

        Set<String> inter = setOps.intersect("set2");
        setOps.intersectAndStore("set2", "inter");

        Set<String> diff = setOps.diff("set2");
        setOps.diffAndStore("set2", "diff");

        Set<String> union = setOps.union("set2");
        setOps.unionAndStore("set2", "union");
    }

    @Test
    public void multiOpsSetz() {
        Set<ZSetOperations.TypedTuple<String>> zset = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            double score = i * 0.1;
            DefaultTypedTuple<String> typedTuple = new DefaultTypedTuple<>("value" + i, score);
            zset.add(typedTuple);
        }

        stringRedisTemplate.opsForZSet().add("zset", zset);
        BoundZSetOperations<String, String> zSetOps = stringRedisTemplate.boundZSetOps("zset");
        Set<String> range = zSetOps.range(1, 6);
        System.out.println(range);

        Set<String> rangeByScore = zSetOps.rangeByScore(0.2, 0.6);

        RedisZSetCommands.Range rg = new RedisZSetCommands.Range();
        rg.gt("value3");
        rg.lt("value8");
        Set<String> rangeByLex = zSetOps.rangeByLex(rg);
        System.out.println(rangeByLex);

        Double value8 = zSetOps.score("value8");
        System.out.println(value8);

        Set<ZSetOperations.TypedTuple<String>> tuples = zSetOps.rangeWithScores(1, 6);
        Set<ZSetOperations.TypedTuple<String>> typedTuples = zSetOps.rangeByScoreWithScores(0.2, 0.8);

        Set<String> reverseRange = zSetOps.reverseRange(2, 8);
        System.out.println(reverseRange);
    }

    @Test
    public void multiOpsTranaction() {
        stringRedisTemplate.opsForValue().set("key1", "value1");
        stringRedisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations ro) throws DataAccessException {
                ro.watch("key1");
                ro.multi();
                ro.opsForValue().increment("key1", 1);
                ro.opsForValue().set("key2", "value2");
                Object val2 = ro.opsForValue().get("key2");
                System.out.println(val2);
                ro.opsForValue().set("key3", "value3");
                Object val3 = ro.opsForValue().get("key3");
                System.out.println(val3);
                return ro.exec();
            }
        });
    }

    @Test
    public void multiOpsPiprline() {
        long start = System.currentTimeMillis();
        stringRedisTemplate.executePipelined(new SessionCallback() {
            @Override
            public Object execute(RedisOperations ro) throws DataAccessException {
                for (int i = 0; i < 100000; i++) {
                    ro.opsForValue().set("pipeline_" + i, "value_" + i);
                }
                return null;
            }
        });
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "毫秒");
    }


    @Test
    public void sendMessage() {
        stringRedisTemplate.convertAndSend("topic1", "msg");
    }





}
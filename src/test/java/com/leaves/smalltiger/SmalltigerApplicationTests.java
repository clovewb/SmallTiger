package com.leaves.smalltiger;

import com.leaves.smalltiger.common.po.Consumer;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmalltigerApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void redisTest() {
        Consumer consumer1 = new Consumer();
        Consumer consumer2 = new Consumer();
        Consumer consumer3 = new Consumer();
        Consumer consumer4 = new Consumer();
        consumer1.setConId(123);
        consumer2.setConId(456);
        consumer3.setConId(789);
        consumer4.setConId(7890);
        consumer1.setConName("AAA");
        consumer2.setConName("BBB");
        consumer3.setConName("CCC");
        consumer4.setConName("DDD");
        List<Consumer> consumers = new ArrayList<>();
        consumers.add(consumer1);
        consumers.add(consumer2);
        consumers.add(consumer3);
        redisTemplate.opsForValue().set("cons",consumers);
    }
}

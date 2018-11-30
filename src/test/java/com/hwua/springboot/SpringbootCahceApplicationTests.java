package com.hwua.springboot;

import com.hwua.springboot.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootCahceApplicationTests {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate myRedisTemplate;

    @Test
    public void contextLoads() {
        stringRedisTemplate.opsForValue().set("k1","v1");
    }

    @Test
    public void test1() {
        Student student= new Student(3,"小强","1003","1",20);
        myRedisTemplate.opsForValue().set("stu-3",student);

    }

}

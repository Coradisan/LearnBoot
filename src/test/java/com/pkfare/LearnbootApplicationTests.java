package com.pkfare;

import com.learn.jms.SpringProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Configuration("producer.xml")
public class LearnbootApplicationTests {


//    @Test
//    public void contextLoads() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
//        SpringProducer producer = context.getBean(SpringProducer.class);
//        producer.sendMessage("123");
//    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
        SpringProducer producer = context.getBean(SpringProducer.class);
        producer.sendMessage("123");
    }

}

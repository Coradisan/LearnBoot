package com.learn.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProducerTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("producer.xml");
//        SpringProducer producer = context.getBean(SpringProducer.class);
//        for (int i = 0; i < 100; i++) {
//            producer.sendMessage("Producer: " + (i + 1));
//        }

        SpringCustomer customer = context.getBean(SpringCustomer.class);
        customer.receive();

    }
}

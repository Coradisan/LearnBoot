package com.learn.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class SpringCustomer {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Resource(name = "queueDestination")
    private Destination destination;


    public void receive() {
        try {
            TextMessage receive = (TextMessage) jmsTemplate.receive(destination);
            System.out.println(receive.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}

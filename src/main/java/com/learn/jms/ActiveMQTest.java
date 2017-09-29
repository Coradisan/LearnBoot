package com.learn.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ActiveMQTest {

    private static String URL = "tcp://127.0.0.1:61616";
    private static String QUEUE_NAME = "刘佳晨的消息队列 ";

    public static void main(String[] args) throws Exception {
        customerTest();
//        proTest();
    }


    public static void proTest() throws Exception {
        //1.简历连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        //2.建立连接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //3.建立回话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地
        Destination destination = session.createQueue(QUEUE_NAME);
        //5.创建生产者
        MessageProducer producer = session.createProducer(destination);

        for (int i = 0; i < 10; i++) {
            Message message = session.createTextMessage("这是第几条message：" + i);
            producer.send(destination, message);
            System.out.println("send: " + message);
        }

        connection.close();
    }

    public static void customerTest() throws Exception {
        //1.简历连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        //2.建立连接
        Connection connection = connectionFactory.createConnection();
        connection.start();
        //3.建立回话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4.创建目的地
        Destination destination = session.createQueue(QUEUE_NAME);
        //5.创建生产者
        MessageConsumer consumer = session.createConsumer(destination);

        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println(textMessage);
                    System.out.println("消费者 :" + textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

//        connection.close();
    }
}
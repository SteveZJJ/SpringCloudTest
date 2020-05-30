//package com.asiainfo.billing.clouduser.util;
//
//import com.rabbitmq.client.Channel;
//import com.rabbitmq.client.Connection;
//import com.rabbitmq.client.ConnectionFactory;
//import com.rabbitmq.client.QueueingConsumer;
//
///**
// * description: RabbitmqConnectionUtil <br>
// * date: 2020/3/24 17:29 <br>
// * author: YangRan <br>
// * version: 1.0 <br>
// */
//public class RabbitmqConnectionUtil {
//
//    private final static String QUEUE_NAME = "q_test_01";
//
//
//    public static Connection getConnection() throws Exception {
//        //定义连接工厂
//        ConnectionFactory factory = new ConnectionFactory();
//        //设置服务地址
//        factory.setHost("127.0.0.1");
//        //端口
//        factory.setPort(5672);
//        //设置账号信息，用户名、密码、vhost
//        factory.setVirtualHost("/user");
//        factory.setUsername("admin");
//        factory.setPassword("admin");
//        // 通过工程获取连接
//        Connection connection = factory.newConnection();
//        return connection;
//    }
//
//    public static void main(String[] args) throws Exception {
//// 获取到连接以及mq通道
//        Connection connection = RabbitmqConnectionUtil.getConnection();
//        // 从连接中创建通道
//        Channel channel = connection.createChannel();
//
//        // 声明（创建）队列
//        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//
//        // 消息内容
//        String message = "Hello!";
//        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
//        System.out.println(" [x] Sent '" + message + "'");
////
////
//        // 定义队列的消费者
//        QueueingConsumer consumer = new QueueingConsumer(channel);
//
//        // 监听队列
//        channel.basicConsume(QUEUE_NAME, true, consumer);
//
//        // 获取消息
//        while (true) {
//            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
//            String getMessage = new String(delivery.getBody());
//            System.out.println(" [x] Received '" + message + "'");
//        }
//        //关闭通道和连接
////        channel.close();
////        connection.close();
//
//    }
//
//}
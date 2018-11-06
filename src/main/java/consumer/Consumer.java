package consumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
public class Consumer {
    private static final String BROKER_URL = "tcp://localhost:61616";
    public static void main(String[] args) {
        //创建JMS连接
        ConnectionFactory connectionFactory;
        //客户端的JMS连接
        Connection connection = null;
        //一个发送或接收消息的线程
        Session session;
        //(目的地)发送到哪里去
        Destination destination;
        //消息的发送者
        MessageConsumer consumer;
        //获得connectionFactory的实例对象
        connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, BROKER_URL);
        try {
            //从工厂连接对象中获得连接对象
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //获取操作这的操作线程
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            //获取destination
            destination = session.createQueue("firstQueue");
            //生成消息接收者
           consumer=session.createConsumer(destination);
           //一直监听
            while (true){
                TextMessage message=(TextMessage) consumer.receive();
                if (null != message) {
                    System.out.println("收到消息" + message.getText());
                } else {
                    break;
                }
            }


        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection)
                    connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }
    }
}

package utils;

import javax.jms.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
public class ConnUtis {
    public  static Map<String,Object> getConnection(ConnectionFactory connectionFactory, Connection connection, Session session, Destination destination, MessageProducer producer ){
        Map<String,Object> map=new HashMap<String,Object>();
        return map;
    }
}

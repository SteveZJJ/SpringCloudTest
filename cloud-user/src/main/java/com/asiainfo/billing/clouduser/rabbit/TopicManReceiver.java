package com.asiainfo.billing.clouduser.rabbit;

import com.asiainfo.billing.clouduser.model.UserInfo;
import com.asiainfo.billing.clouduser.service.UserInfoService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * description: TopicManReceiver <br>
 * date: 2020/3/25 16:53 <br>
 * author: YangRan <br>
 * version: 1.0 <br>
 */
@Component
@RabbitListener(queues = "topic.man")
public class TopicManReceiver {

    @Autowired
    UserInfoService userInfoService;

    @RabbitHandler
    public void process(Map testMessage) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(78);
        userInfo.setUserAge(25);
        userInfo.setUserName(String.valueOf(testMessage.get("messageData")));
        userInfoService.save(userInfo);
        System.out.println("TopicManReceiver消费者收到消息  : " + testMessage.toString());
    }
}

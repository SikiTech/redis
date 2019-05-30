/**
 * projectName: redis
 * fileName: RedisMessageListener.java
 * packageName: com.sikiapp.redis.push
 * date: 2019-05-30 上午8:34
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.push;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @className: RedisMessageListener
 * @packageName: com.sikiapp.redis.push
 * @description: Redis 消息监听器
 * @author: Robert
 * @data: 2019-05-30 上午8:34
 * @version: V1.0
 **/
@Component
public class RedisMessageListener implements MessageListener {

    @Override
    public void onMessage(Message message, byte[] bytes) {
        // 消息体
        String body = new String(message.getBody());
        // 渠道
        String channel = new String(bytes);
        //业务
        System.out.println("body:" + body);
        System.out.println("channel:" + channel);
    }
}
/**
 * projectName: redis
 * fileName: RedisMessageContainer.java
 * packageName: com.sikiapp.redis.push
 * date: 2019-05-30 上午8:41
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 * @className: RedisMessageContainer
 * @packageName: com.sikiapp.redis.push
 * @description: Redis 消息监听容器
 * @author: Robert
 * @data: 2019-05-30 上午8:41
 * @version: V1.0
 **/
@Configuration
public class RedisMessageContainer  {

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Autowired
    private RedisMessageListener messageListener;

    @Bean
    @ConditionalOnMissingBean
    public ThreadPoolTaskScheduler initTaskScheduiler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(20);
        return taskScheduler;
    }

    @Bean
    public RedisMessageListenerContainer initRedisContainer(ThreadPoolTaskScheduler threadPoolTaskScheduler) {
        RedisMessageListenerContainer listenerContainer = new RedisMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        listenerContainer.setTaskExecutor(threadPoolTaskScheduler);

        listenerContainer.addMessageListener(messageListener, new ChannelTopic("topic1"));
        return listenerContainer;
    }


}
/**
 * projectName: redis
 * fileName: StoreStartupRunner.java
 * packageName: com.sikiapp.redis.manager
 * date: 2019-05-30 下午5:25
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @className: StoreStartupRunner
 * @packageName: com.sikiapp.redis.manager
 * @description: 店铺初始化到缓存
 * @author: Robert
 * @data: 2019-05-30 下午5:25
 * @version: V1.0
 **/
//@Component
public class StoreStartupRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(StoreStartupRunner.class);

    @Autowired
    private RedisTemplate redisTemplate;

//    @Autowired
//    private UserAuthMapper userAuthMapper;

    @Override
    public void run(String... args) throws Exception {
//        List<UserAuth> auths = userAuthMapper.selectList(null);
//
//        redisTemplate.executePipelined(new SessionCallback() {
//            @Override
//            public Object execute(RedisOperations ro) throws DataAccessException {
//                auths.forEach(action -> {
////                    ro.opsForHash().put("auths", "auth_" + action.getId(), action);
//                });
//                return null;
//            }
//        });
    }
}







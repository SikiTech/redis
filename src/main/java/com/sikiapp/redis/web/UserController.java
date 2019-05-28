/**
 * projectName: spring-boot-in-action
 * fileName: UserController.java
 * packageName: com.sikiapp.springbootinaction.web
 * date: 2019-05-28 上午11:13
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.web;

import com.sikiapp.redis.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @className: UserController
 * @packageName: com.sikiapp.springbootinaction.web
 * @description: 用户控制
 * @author: Robert
 * @data: 2019-05-28 上午11:13
 * @version: V1.0
 **/
@RestController
public class UserController {

    @RequestMapping("/getUser")
    @Cacheable(value = "user-key")
    public User getUser() {
        User user = new User("robert", "男", 28);
        return user;
    }


}
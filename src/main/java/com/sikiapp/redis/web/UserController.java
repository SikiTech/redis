/**
 * projectName: spring-boot-in-action
 * fileName: UserController.java
 * packageName: com.sikiapp.redis.web
 * date: 2019-05-28 上午11:13
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.web;

import com.sikiapp.redis.Exception.ErrorResponseEntity;
import com.sikiapp.redis.mapper.UserAuthMapper;
import com.sikiapp.redis.model.User;
import com.sikiapp.redis.model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @className: UserController
 * @packageName: com.sikiapp.redis.web
 * @description: 用户控制
 * @author: Robert
 * @data: 2019-05-28 上午11:13
 * @version: V1.0
 **/
@RestController
public class UserController {

    @Autowired
    private UserAuthMapper userAuthMapper;

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User("robert", "男", 28);
        return user;
    }

    @RequestMapping("/auths")
    public List<UserAuth> getAuth() {
        return userAuthMapper.selectByUserBaseId(1196);
    }

    @RequestMapping("/save")
    public String insetAuth() {
        UserAuth userAuth = new UserAuth();
        userAuth.setUser(1196);
        userAuth.setIdentityType((byte)2);
        userAuth.setIdentifier("tokenxxxxxx");
        int i = userAuthMapper.insertSelective(userAuth);

        System.out.println(userAuth.getId());
        return "success";
    }

    @RequestMapping("/exceptions")
    public ErrorResponseEntity cumstEx() {
        return new ErrorResponseEntity(400, "自定义错误");
    }







}
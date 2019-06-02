/**
 * projectName: redis
 * fileName: UserAuthController.java
 * packageName: com.sikiapp.redis.web
 * date: 2019-05-30 上午11:00
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.web;

import com.sikiapp.redis.entity.UserAuth;
import com.sikiapp.redis.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: UserAuthController
 * @packageName: com.sikiapp.redis.web
 * @description: 用户控制
 * @author: Robert
 * @data: 2019-05-30 上午11:00
 * @version: V1.0
 **/
@RestController
@RequestMapping("/auths")
public class UserAuthController {

    @Autowired
    private UserAuthService userAuthService;

    @GetMapping("/one")
    public UserAuth selectByIdentifier(Integer id) {
//        return userAuthService.getOne(id);
        return null;
    }

    @GetMapping("/identifier")
    public UserAuth selectByIdentifier(String identifier, String certificate, Byte identityType) {
//        return userAuthService.selectByIdentifier(identifier, certificate, identityType);
        return null;
    }

    @GetMapping("/modify")
    public UserAuth updatePasswordByPhone(String identifier, String certificate) throws Exception {
//        return userAuthService.updatePasswordByPhone(identifier, certificate);
        return null;
    }

    @GetMapping("/del")
    public int deleteUserAuth(Integer id) {
//        return userAuthService.deleteUserAuth(id);
        return 0;
    }


}
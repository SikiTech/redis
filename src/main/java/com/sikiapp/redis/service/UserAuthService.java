/**
 * projectName: redis
 * fileName: UserAuthService.java
 * packageName: com.sikiapp.redis.push
 * date: 2019-05-30 上午10:03
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.service;

import com.sikiapp.redis.model.UserAuth;
import org.apache.ibatis.annotations.Param;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @className: UserAuthService
 * @packageName: com.sikiapp.redis.push
 * @description: 用户权限
 * @author: Robert
 * @data: 2019-05-30 上午10:03
 * @version: V1.0
 **/
public interface UserAuthService {

    List<UserAuth> selectByUserBaseId(Integer userBaseId);
    UserAuth getOne(@NotNull Integer id);
    UserAuth selectByIdentifier(String identifier, String certificate, Byte identityType);
    UserAuth updatePasswordByPhone(@NotBlank String identifier, @NotBlank String certificate);
    int deleteUserAuth(@NotNull Integer id);
}
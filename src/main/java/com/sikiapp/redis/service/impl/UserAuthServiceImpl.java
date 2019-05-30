/**
 * projectName: redis
 * fileName: UserAuthServiceImpl.java
 * packageName: com.sikiapp.redis.service.impl
 * date: 2019-05-30 上午10:04
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.service.impl;

import com.sikiapp.redis.mapper.UserAuthMapper;
import com.sikiapp.redis.model.UserAuth;
import com.sikiapp.redis.service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @className: UserAuthServiceImpl
 * @packageName: com.sikiapp.redis.service.impl
 * @description: 用户权限实现类
 * @author: Robert
 * @data: 2019-05-30 上午10:04
 * @version: V1.0
 **/
@Service
public class UserAuthServiceImpl implements UserAuthService {

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Override
    public List<UserAuth> selectByUserBaseId(Integer userBaseId) {
        return null;
    }

    @Override
    @Cacheable(cacheNames = "redisCache", key = "'redis_user_' + #id")
    public UserAuth getOne(@NotNull Integer id) {
        return userAuthMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CachePut(value = "redisCache", key = "'redis_user_' + #result.id")
    public UserAuth selectByIdentifier(String identifier, String certificate, Byte identityType) {
        return userAuthMapper.selectByIdentifier(identifier, certificate, identityType);
    }

    @Override
    @Transactional(rollbackFor = NullPointerException.class)
    @CachePut(value = "redisCache", key = "'redis_user_' + #result.id")
    public UserAuth updatePasswordByPhone(@NotBlank String identifier, @NotBlank String certificate) {
        UserAuth auth = selectByIdentifier(identifier, certificate, (byte) 1);
        auth.setIdentifier(identifier);
        auth.setCertificate(certificate);

        userAuthMapper.updatePasswordByPhone(identifier, certificate);
        return auth;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = "redisCache", key = "'redis_user_' + #id", beforeInvocation = false)
    public int deleteUserAuth(@NotNull Integer id) {
        return userAuthMapper.deleteByPrimaryKey(id);
    }


}
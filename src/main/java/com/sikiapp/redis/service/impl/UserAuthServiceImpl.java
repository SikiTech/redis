package com.sikiapp.redis.service.impl;

import com.sikiapp.redis.entity.UserAuth;
import com.sikiapp.redis.mapper.UserAuthMapper;
import com.sikiapp.redis.service.UserAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户授权表 服务实现类
 * </p>
 *
 * @author robert
 * @since 2019-06-02
 */
@Service
public class UserAuthServiceImpl extends ServiceImpl<UserAuthMapper, UserAuth> implements UserAuthService {

}

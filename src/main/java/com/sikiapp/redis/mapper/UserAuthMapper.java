/**
 * projectName: spring-boot-in-action
 * fileName: UserAuthMapper.java
 * packageName: com.sikiapp.redis.mapper
 * date: 2019-05-15 下午3:44
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.mapper;

import com.sikiapp.redis.model.UserAuth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @className: UserAuthMapper
 * @packageName: com.sikiapp.redis.mapper
 * @description: Mapper Mybatis Demo
 * @author: Robert
 * @data: 2019-05-15 下午3:44
 * @version: V1.0
 **/
@Mapper
public interface UserAuthMapper extends BaseMapper<UserAuth> {

    List<UserAuth> selectByUserBaseId(Integer userBaseId);
    UserAuth selectByIdentifier(@Param("identifier") String identifier, @Param("certificate") String certificate, @Param("identityType") Byte identityType);
    int updatePasswordByPhone(@Param("identifier") String identifier, @Param("certificate") String certificate);


}
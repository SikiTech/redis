/**
 * projectName: redis
 * fileName: MybatisPlusTest.java
 * packageName: com.sikiapp.redis
 * date: 2019-05-30 下午7:18
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sikiapp.redis.entity.UserAuth;
import com.sikiapp.redis.mapper.UserAuthMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @className: MybatisPlusTest
 * @packageName: com.sikiapp.redis
 * @description: Mybatis-Plus Test
 * @author: Robert
 * @data: 2019-05-30 下午7:18
 * @version: V1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Test
    public void selectAll() {
        QueryWrapper<UserAuth> wrapper = new QueryWrapper<>();
        wrapper.ge("user", 1200);
        List<UserAuth> userAuths = userAuthMapper.selectList(wrapper);
        System.out.println(userAuths.size());
    }

    @Test
    public void selectLambda() {
        QueryWrapper<UserAuth> wrapper = new QueryWrapper<>();
        wrapper.lambda().ge(UserAuth::getUser, 1200);
        List<UserAuth> userAuths = userAuthMapper.selectList(wrapper);
        System.out.println(userAuths.size());
    }

    @Test
    public void t() {
    }

    @Test
    public void selectAllPage() {
        List<UserAuth> userAuths = userAuthMapper.selectList(null);
        System.out.println(userAuths.size());
    }

    @Test
    public void selectPageVo() {
        Page<UserAuth> page = new Page<>(1L, 10L);
//        IPage<UserAuth> authIPage = userAuthMapper.selectPageVo(page, (byte) 1);
//        System.out.println(authIPage);
    }


    @Test
    public void testInsert() {
        UserAuth auth = new UserAuth();
        auth.setIdentifier("180000000000");
        auth.setCertificate("12245");
        auth.setFace("");
//        auth.setIdentityType((byte)1);
        auth.setName("");
        int row = userAuthMapper.insert(auth);
        Assert.assertEquals(row, 1);
//        assertThat(auth.getId()).isNotNull();
    }

    @Test
    public void testDelete() {
        assertThat(userAuthMapper.deleteById(36330)).isGreaterThan(0);
        assertThat(userAuthMapper.delete(new QueryWrapper<UserAuth>()
                .lambda().eq(UserAuth::getName, "用户1224"))).isGreaterThan(0);
    }

    @Test
    public void testupdate() {

//        assertThat(userAuthMapper.updateById(new UserAuth().setId(36349).setName("Robert"))).isGreaterThan(0);

//        assertThat(userAuthMapper.update(new UserAuth().setName("用户12345"),
//                Wrappers.<UserAuth>lambdaUpdate()
//                        .set(UserAuth::getFace, "facexxxx")
//                        .eq(UserAuth::getId, 36343))).isGreaterThan(0);
    }

    @Test
    public void testOrder() {
//        LambdaQueryWrapper<UserAuth> wrapper = Wrappers.<UserAuth>lambdaQuery().orderByAsc(UserAuth::getId);
//        List<UserAuth> auths = userAuthMapper.selectList(wrapper);
//        auths.forEach(o -> System.out.println(o));
    }




    @Test
    public void testGroup() {

        QueryWrapper<UserAuth> wrapper = new QueryWrapper<>();
        List<Map<String, Object>> maps = userAuthMapper.selectMaps(wrapper);
        maps.forEach(mp -> {
            System.out.println(mp);
        });
    }






}
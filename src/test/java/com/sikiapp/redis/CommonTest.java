/**
 * projectName: redis
 * fileName: CommonTest.java
 * packageName: com.sikiapp.redis
 * date: 2019-05-30 下午2:43
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @className: CommonTest
 * @packageName: com.sikiapp.redis
 * @description:
 * @author: Robert
 * @data: 2019-05-30 下午2:43
 * @version: V1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTest {

    @Test
    public void reg() {
        String orgin = "https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epbVkL0SRib0CDsWS16n0iaDMG3OAo2H9ymibtOzxAW3vPTFBPLCgnmFGqib2PSyT4yGkls3t6pXGDibKw/132";
        String pattern = "^https://thirdwx.*/132$";
        if (orgin.matches(pattern)) {
            String s = orgin.replaceAll("/132$", "/0");
            System.out.println(s);
        }
        System.out.println(orgin);
    }

    /**
     * Lombok 链式编程
     */
    @Test
    public void lombokChain() {
//        Book book = Book.of(123).setName("");
//        User user = User.builder().id(1234L).roleName("robert").build();

    }

    @Test
    public void big() {
        String orgin = "https://thirdwx.qlogo.cn/mmopen/vi_32/DYAIOgq83epbVkL0SRib0CDsWS16n0iaDMG3OAo2H9ymibtOzxAW3vPTFBPLCgnmFGqib2PSyT4yGkls3t6pXGDibKw/132";
        orgin = bigPicture(orgin);
        System.out.println(orgin);
    }


    private String bigPicture(String origin) {
        String pattern = "^https://thirdwx.*/132$";
        if (origin.matches(pattern)) {
            return origin.replaceAll("/132$", "/0");
        }

        return origin;
    }
}
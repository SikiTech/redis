/**
 * projectName: redis
 * fileName: MybatisPlusConfig.java
 * packageName: com.sikiapp.redis.mybatis
 * date: 2019-05-30 下午8:52
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.mybatis;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: MybatisPlusConfig
 * @packageName: com.sikiapp.redis.mybatis
 * @description: MybatisPlusConfig
 * @author: Robert
 * @data: 2019-05-30 下午8:52
 * @version: V1.0
 **/
@EnableTransactionManagement
@Configuration
@MapperScan("com.sikiapp.redis.mapper")
public class MybatisPlusConfig {

    /**
     *@description: 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor interceptor = new PaginationInterceptor();
        interceptor.setDialectType("mysql");
        List<ISqlParser> sqlParserList = new ArrayList<>();
        // 攻击 SQL 阻断解析器、加入解析链（阻止恶意的全表更新删除）
        sqlParserList.add(new BlockAttackSqlParser());
        return interceptor;
    }

    /**
     * @description: SQL执行效率插件
     */
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }


}
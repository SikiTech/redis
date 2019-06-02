/**
 * projectName: redis
 * fileName: StoreController.java
 * packageName: com.sikiapp.redis.web
 * date: 2019-06-01 上午9:23
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sikiapp.redis.entity.Store;
import com.sikiapp.redis.mapper.StoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @className: StoreController
 * @packageName: com.sikiapp.redis.web
 * @description: 店铺控制层
 * @author: Robert
 * @data: 2019-06-01 上午9:23
 * @version: V1.0
 **/
@RestController
@RequestMapping("/stores")
public class StoreController {


    @Autowired
    private StoreMapper storeMapper;

    @GetMapping("/page")
    public IPage<Store> selectPage() {
        Page<Store> page = new Page<>(1, 5);
        return storeMapper.selectPage(page, Wrappers.<Store>lambdaQuery().orderByAsc(Store::getCombine));
    }


}
/**
 * projectName: spring-boot-in-action
 * fileName: Book.java
 * packageName: com.sikiapp.redis.com.sikiapp.redis.model
 * date: 2019-05-23 上午11:46
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @className: Book
 * @packageName: com.sikiapp.redis.com.sikiapp.redis.model
 * @description: Book 类
 * @author: Robert
 * @data: 2019-05-23 上午11:46
 * @version: V1.0
 **/
@Data
public class Book implements Serializable {

    private Integer id;
    private String name;
}
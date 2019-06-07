/**
 * projectName: redis
 * fileName: BaseController.java
 * packageName: com.sikiapp.redis.controller
 * date: 2019-06-03 下午4:39
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @className: BaseController
 * @packageName: com.sikiapp.redis.controller
 * @description:
 * @author: Robert
 * @data: 2019-06-03 下午4:39
 * @version: V1.0
 **/
public class BaseController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected HttpServletResponse response;

    protected String redirectTo( String url ) {
        StringBuffer rto = new StringBuffer("redirect:");
        rto.append(url);
        return rto.toString();
    }
}
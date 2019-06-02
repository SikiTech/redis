/**
 * projectName: redis
 * fileName: ServiceEnum.java
 * packageName: com.sikiapp.redis.enums
 * date: 2019-05-31 下午10:13
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @className: ServiceEnum
 * @packageName: com.sikiapp.redis.enums
 * @description: 服务评价 (推荐使用此方案实现枚举)
 * @author: Robert
 * @data: 2019-05-31 下午10:13
 * @version: V1.0
 **/
public enum ServiceEnum implements IEnum<Integer> {

    /**
     * 服务等级一星～五星
     */
    ONE(1, "吐槽"),
    TWO(2, "较差"),
    THREE(3, "一般"),
    FOUR(4, "满意"),
    FIVE(5, "超赞");

    private int value;
    private String descp;

    ServiceEnum(final int value, final String desc) {
        this.value = value;
        this.descp = desc;
    }

    @JsonValue
    @Override
    public Integer getValue() {
        return value;
    }
}
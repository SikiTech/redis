/**
* projectName: redis
 * fileName: SpeedEnum.java
 * packageName: com.sikiapp.redis.enums
 * date: 2019-05-31 下午10:58
 * copyright(c) 2018-2028 深圳识迹科技有限公司
 */
package com.sikiapp.redis.enums;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @className: SpeedEnum
 * @packageName: com.sikiapp.redis.enums
 * @description: 上菜速度
 * @author: Robert
 * @data: 2019-05-31 下午10:58
 * @version: V1.0
 **/
public enum SpeedEnum {
    /**
     * 服务等级一星～五星
     */
    ONE(1, "吐槽"),
    TWO(2, "较差"),
    THREE(3, "一般"),
    FOUR(4, "满意"),
    FIVE(5, "超赞");

    @EnumValue
    @JSONField(serialzeFeatures= SerializerFeature.WriteEnumUsingToString)
    private int value;
    private String descp;

    SpeedEnum(int value, String descp) {
        this.value = value;
        this.descp = descp;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
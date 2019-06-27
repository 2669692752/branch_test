package com.jm.test.enums;

import lombok.Getter;

/**
 * @author lyx
 * @date 2018/5/21 18:02
 **/
@Getter
public enum ResultEnum {

    /**
     * 返回结果
     */
    FIND_SUCCESS(100, "查询成功"),
    FIND_ERROR(101, "查询失败"),
    ADD_SUCCESS(102, "添加成功"),
    ADD_ERROR(103, "添加失败");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}

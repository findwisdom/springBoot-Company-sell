package com.imooc.sell.enums;

import lombok.Getter;

@Getter
public enum ResponseStatusEnum implements CodeEnum{
    Success(0, "成功"),
    Fail(1, "失败")
    ;

    private Integer code;

    private String message;

    ResponseStatusEnum (Integer code, String message) {
        this.code = code;
        this.message = message;

    }

}

package com.fengwenyi.studyspringbootdatajpa.enums;

import lombok.Getter;

/**
 * @author Erwin Feng
 * @since 2020-12-29
 */
@Getter
public enum UserStatusEnum {
    NORMAL(0, "正常"),
    LOCKED(-1, "锁定"),
    CANCELLATION(-2, "注销"),
    ;

    private final Integer code;

    private final String desc;

    UserStatusEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

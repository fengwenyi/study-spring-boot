package com.fengwenyi.studyspringbootdatajpa.enums;

import lombok.Getter;

/**
 * @author Erwin Feng
 * @since 2020-12-29
 */
@Getter
public enum GenderEnum {

    MALE("男"),
    FEMALE("女");

    private final String name;

    GenderEnum(String name) {
        this.name = name;
    }
}

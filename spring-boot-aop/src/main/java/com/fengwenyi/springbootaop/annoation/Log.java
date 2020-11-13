package com.fengwenyi.springbootaop.annoation;

import java.lang.annotation.*;

/**
 * @author Erwin Feng
 * @since 2020-11-13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
}

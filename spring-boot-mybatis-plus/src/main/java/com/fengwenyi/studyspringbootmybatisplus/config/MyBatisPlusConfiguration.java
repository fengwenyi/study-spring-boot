package com.fengwenyi.studyspringbootmybatisplus.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Erwin Feng
 * @since 2020-11-16
 */
@Configuration
@MapperScan("com.fengwenyi.studyspringbootmybatisplus.db.mapper")
public class MyBatisPlusConfiguration {
}

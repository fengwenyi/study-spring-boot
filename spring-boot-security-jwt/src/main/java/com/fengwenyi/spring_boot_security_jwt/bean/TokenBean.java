package com.fengwenyi.spring_boot_security_jwt.bean;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/27
 */
@Data
@Accessors(chain = true)
public class TokenBean {

    /** UID */
    private String uid;

    /** UID */
    private String token;

    /** 过期时间 */
    private LocalDateTime expireDate;
}

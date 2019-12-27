package com.fengwenyi.spring_boot_security_jwt.util;

import com.fengwenyi.spring_boot_security_jwt.bean.AuthenticationUser;
import com.fengwenyi.spring_boot_security_jwt.entity.UserEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/25
 */
public class MyUserUtils {

    private static Map<String, UserEntity> map = new HashMap<>();

    // 通过用户名查询
    public static UserEntity getByUsername(String username) {
        return map.get(username);
    }

    // 通过uid 查询
    // 这里只是假设，实际是用username查询
    public static UserEntity getByUid(String uid) {
        return map.get(uid);
    }

    public static void set() {
        if (!map.isEmpty()) {
            return;
        }
        // 123456
        String password = "$2a$10$PZ8TCgeB1wpaHqMs56Zv0O/Equ84NdFKmH3Vx5jqY./MvbaRgAV/i";
        UserEntity userEntity = new UserEntity()
                .setUid(UUID.randomUUID().toString())
                .setNickname("张飞")
                .setUsername("zf")
                .setPassword(password)
                .setRoleList(Arrays.asList("ROLE_USER"));
        map.put(userEntity.getUsername(), userEntity);
        userEntity = new UserEntity()
                .setUid(UUID.randomUUID().toString())
                .setNickname("赵子龙")
                .setUsername("zzl")
                .setPassword(password)
                .setRoleList(Arrays.asList("ROLE_USER"));
        map.put(userEntity.getUsername(), userEntity);
        userEntity = new UserEntity()
                .setUid(UUID.randomUUID().toString())
                .setNickname("艾克")
                .setUsername("ekko")
                .setPassword(password)
                .setRoleList(Arrays.asList("ROLE_USER"));
        map.put(userEntity.getUsername(), userEntity);
        userEntity = new UserEntity()
                .setUid(UUID.randomUUID().toString())
                .setNickname("管理员")
                .setUsername("admin")
                .setPassword(password)
                .setRoleList(Arrays.asList("ROLE_USER", "ROLE_ADMIN"));
        map.put(userEntity.getUsername(), userEntity);
    }

    public static void remove(String username) {
        map.remove(username);
    }


    public static AuthenticationUser getLoginUser() {

        /**
         SecurityContextHolder.getContext()获取安全上下文对象，就是那个保存在 ThreadLocal 里面的安全上下文对象
         总是不为null(如果不存在，则创建一个authentication属性为null的empty安全上下文对象)
         获取当前认证了的 principal(当事人),或者 request token (令牌)
         如果没有认证，会是 null,该例子是认证之后的情况
         */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //有登陆用户就返回登录用户，没有就返回null
        if (authentication != null) {
            if (authentication instanceof AnonymousAuthenticationToken) {
                return null;
            }

            if (authentication instanceof UsernamePasswordAuthenticationToken) {
                return (AuthenticationUser) authentication.getPrincipal();
            }
        }

        return null;
    }
}

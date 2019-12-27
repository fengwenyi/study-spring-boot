package com.fengwenyi.spring_boot_security_jwt_json.util;

import com.fengwenyi.spring_boot_security_jwt_json.entity.UserEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;

/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/25
 */
public class MyUserUtils {

    private static Map<String, UserEntity> map = new HashMap<>();

    public static UserEntity getByUsername(String username) {
        return map.get(username);
    }

    public static void set() {
        if (!map.isEmpty()) {
            return;
        }
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

}

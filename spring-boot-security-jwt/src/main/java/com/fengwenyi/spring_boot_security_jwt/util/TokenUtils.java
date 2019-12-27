package com.fengwenyi.spring_boot_security_jwt.util;

import com.fengwenyi.spring_boot_security_jwt.bean.TokenBean;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 将token保存到内存中（map）
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/27
 */
public class TokenUtils {

    private static Map<String, TokenBean> map = new HashMap<>();

    // 设置
    public static void set(String uid, String token) {
        LocalDateTime expireDate = LocalDateTime.now().plusMinutes(3);
        TokenBean tokenBean = new TokenBean()
                .setUid(uid)
                .setToken(token)
                .setExpireDate(expireDate);
        map.put(uid, tokenBean);
    }

    // 移除
    public static void remove(String uid) {
        map.remove(uid);
    }

    // 获取
    public static String get(String uid) {
        TokenBean tokenBean = map.get(uid);
        if (tokenBean == null) {
            return null;
        }
        LocalDateTime expireDate = tokenBean.getExpireDate();
        if (DateTimeUtils.isBefore(LocalDateTime.now(), expireDate)) {
            return tokenBean.getToken();
        }
        remove(uid);
        return null;
    }

}

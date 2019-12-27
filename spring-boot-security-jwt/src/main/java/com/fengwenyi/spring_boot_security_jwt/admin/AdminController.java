package com.fengwenyi.spring_boot_security_jwt.admin;

import com.fengwenyi.spring_boot_security_jwt.bean.AuthenticationUser;
import com.fengwenyi.spring_boot_security_jwt.util.MyUserUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


/**
 * @author Erwin Feng[xfsy_2015@163.com]
 * @since 2019/12/25
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/list")
    public String list() {
        return "admin>list";
    }

    /*
    userDates

    {
        "password": "$2a$10$PZ8TCgeB1wpaHqMs56Zv0O/Equ84NdFKmH3Vx5jqY./MvbaRgAV/i",
        "username": "admin",
        "authorities": [
            {
                "authority": "ROLE_ADMIN"
            },
            {
                "authority": "ROLE_USER"
            }
        ],
        "accountNonExpired": true,
        "accountNonLocked": true,
        "credentialsNonExpired": true,
        "enabled": true
    }
     */

    @RequestMapping("/user")
    public AuthenticationUser user() {
        return MyUserUtils.getLoginUser();
    }

    @RequestMapping("/user2")
    public Principal user2(Principal principal) {
        return principal;
    }
    /*
    Principal:
    {
        "authorities": [
            {
                "authority": "ROLE_ADMIN"
            },
            {
                "authority": "ROLE_USER"
            }
        ],
        "details": {
            "remoteAddress": "0:0:0:0:0:0:0:1",
            "sessionId": "FC29035D80354978195212875236BF8B"
        },
        "authenticated": true,
        "principal": {
            "password": "$2a$10$PZ8TCgeB1wpaHqMs56Zv0O/Equ84NdFKmH3Vx5jqY./MvbaRgAV/i",
            "username": "admin",
            "authorities": [
                {
                    "authority": "ROLE_ADMIN"
                },
                {
                    "authority": "ROLE_USER"
                }
            ],
            "accountNonExpired": true,
            "accountNonLocked": true,
            "credentialsNonExpired": true,
            "enabled": true
        },
        "credentials": null,
        "name": "admin"
    }
     */

    @RequestMapping("/user3")
    public Authentication user3(Authentication authentication) {
        return authentication;
    }

    /*
    {
        "authorities": [
            {
                "authority": "ROLE_ADMIN"
            },
            {
                "authority": "ROLE_USER"
            }
        ],
        "details": {
            "remoteAddress": "0:0:0:0:0:0:0:1",
            "sessionId": "67EDB9C9A184C7ABA571892FEFA28B02"
        },
        "authenticated": true,
        "principal": {
            "password": "$2a$10$PZ8TCgeB1wpaHqMs56Zv0O/Equ84NdFKmH3Vx5jqY./MvbaRgAV/i",
            "username": "admin",
            "authorities": [
                {
                    "authority": "ROLE_ADMIN"
                },
                {
                    "authority": "ROLE_USER"
                }
            ],
            "accountNonExpired": true,
            "accountNonLocked": true,
            "credentialsNonExpired": true,
            "enabled": true
        },
        "credentials": null,
        "uid": "9762d087-53ed-4c3d-976b-67a5d3d75a8f",
        "name": "admin"
    }
     */
}

package com.fengwenyi.studyspringbootjsonview.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fengwenyi.studyspringbootjsonview.vo.UserResponseVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erwin Feng
 * @since 2021-01-12
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/user")
    @JsonView(UserResponseVo.SimpleView.class)
    public UserResponseVo user() {
        return getUser();
    }

    @GetMapping("/userDetail")
    @JsonView(UserResponseVo.DetailView.class)
    public UserResponseVo userDetail() {
        return getUser();
    }

    private UserResponseVo getUser() {
        UserResponseVo userResponseVo = new UserResponseVo();
        userResponseVo.setId("001");
        userResponseVo.setName("Zhangsan");
        userResponseVo.setAge(18);
        userResponseVo.setGender("男");
        return userResponseVo;
    }

}

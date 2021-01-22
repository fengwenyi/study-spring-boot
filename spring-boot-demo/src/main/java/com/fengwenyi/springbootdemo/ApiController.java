package com.fengwenyi.springbootdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Erwin Feng
 * @since 2021-01-22
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/user",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiController {

    @PostMapping
    public String user(@RequestBody Map<String, Object> user) {
        log.info(user.toString());
        return "Success";
    }

}

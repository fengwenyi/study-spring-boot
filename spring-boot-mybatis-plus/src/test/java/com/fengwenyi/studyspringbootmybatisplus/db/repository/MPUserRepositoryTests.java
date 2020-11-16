package com.fengwenyi.studyspringbootmybatisplus.db.repository;

import com.fengwenyi.studyspringbootmybatisplus.StudySpringBootMyBatisPlusApplicationTests;
import com.fengwenyi.studyspringbootmybatisplus.db.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Erwin Feng
 * @since 2020-11-16
 */
@Component
@Slf4j
public class MPUserRepositoryTests extends StudySpringBootMyBatisPlusApplicationTests {

    @Autowired
    private MPUserRepository mpUserRepository;

    @Test
    public void testSelectList() {
        List<UserEntity> list = mpUserRepository.list();
        list.forEach(userEntity -> log.info(userEntity.toString()));
    }

}

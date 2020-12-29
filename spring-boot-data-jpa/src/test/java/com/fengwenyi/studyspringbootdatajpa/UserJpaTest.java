package com.fengwenyi.studyspringbootdatajpa;

import com.fengwenyi.studyspringbootdatajpa.entity.UserEntity;
import com.fengwenyi.studyspringbootdatajpa.enums.GenderEnum;
import com.fengwenyi.studyspringbootdatajpa.enums.UserStatusEnum;
import com.fengwenyi.studyspringbootdatajpa.repository.IUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Erwin Feng
 * @since 2020-12-29
 */
@Slf4j
@Component
public class UserJpaTest extends StudySpringBootDataJpaApplicationTests {

    @Autowired
    private IUserRepository iUserRepository;

    @Test
    public void testAdd() {
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setName("貂蝉");
        userEntity1.setAge(16);
        userEntity1.setGender(GenderEnum.FEMALE);
        userEntity1.setStatus(UserStatusEnum.NORMAL);
        iUserRepository.save(userEntity1);

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setName("西施");
        userEntity2.setAge(20);
        userEntity2.setGender(GenderEnum.FEMALE);
        userEntity2.setStatus(UserStatusEnum.LOCKED);
        iUserRepository.save(userEntity2);
    }

    @Test
    public void testQuery() {
        List<UserEntity> userEntityList = iUserRepository.findAll();
        for (UserEntity userEntity : userEntityList) {
            log.info(userEntity.toString());
        }
    }

}

package com.fengwenyi.studyspringbootdatajpa.repository;

import com.fengwenyi.studyspringbootdatajpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Erwin Feng
 * @since 2020-12-29
 */
public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
}

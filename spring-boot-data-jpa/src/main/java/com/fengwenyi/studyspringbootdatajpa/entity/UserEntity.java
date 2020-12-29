package com.fengwenyi.studyspringbootdatajpa.entity;

import com.fengwenyi.studyspringbootdatajpa.enums.GenderEnum;
import com.fengwenyi.studyspringbootdatajpa.enums.UserStatusEnum;
import lombok.Data;

import javax.persistence.*;

/**
 * @author Erwin Feng
 * @since 2020-12-29
 */
@Data
@Entity
@Table(name = "t_user")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatusEnum status;

}

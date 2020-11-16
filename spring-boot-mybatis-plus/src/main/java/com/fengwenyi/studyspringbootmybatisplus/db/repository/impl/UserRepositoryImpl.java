package com.fengwenyi.studyspringbootmybatisplus.db.repository.impl;

import com.fengwenyi.studyspringbootmybatisplus.db.entity.UserEntity;
import com.fengwenyi.studyspringbootmybatisplus.db.mapper.IUserMapper;
import com.fengwenyi.studyspringbootmybatisplus.db.repository.MPUserRepository;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Erwin Feng
 * @since 2020-11-16
 */
@Service
public class UserRepositoryImpl extends ServiceImpl<IUserMapper, UserEntity> implements MPUserRepository {

}

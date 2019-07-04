package com.jm.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jm.test.entiey.User;
import com.jm.test.mapper.UserMapper;
import com.jm.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lyx
 * @date 2019/7/4 16:01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.updateById(user);
    }



}

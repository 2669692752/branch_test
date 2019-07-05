package com.jm.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jm.test.entity.User;
import com.jm.test.mapper.UserMapper;
import com.jm.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lyx
 * @date 2019/7/4 16:01
 */
@Service
@Slf4j
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

    @Override
    public IPage<User> selectMethod() {
//        Integer count = userMapper.selectCount(new QueryWrapper<User>().between("age", 0, 1000));
        // 当前页码，每页条数
        Page<User> pageParam = new Page<>(1, 3);
        LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
        query.between(User::getAge, "0", "100");
        IPage<User> userPage = userMapper.selectPage(pageParam, query);
        if (!userPage.getRecords().isEmpty()) {
            log.info("++一个员工信息+++++" + userPage);
        }
        return userPage;

    }


}

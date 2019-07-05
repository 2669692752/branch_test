package com.jm.test.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jm.test.entity.User;

/**
 * @Author lyx
 * @date 2019/7/4 15:58
 */
public interface UserService extends IService<User> {
    void addUser(User user);

    void update(User user);

    IPage<User> selectMethod();
}

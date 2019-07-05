package com.jm.test.testclass;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jm.test.entity.User;
import com.jm.test.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author lyx
 * @date 2019/7/3 16:07
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(6, userList.size());
        userList.forEach(System.out::println);
    }


    @Test
    public void testInsert() {
        User user = new User();
        user.setName("东方不败1");
        user.setEmail("dfbb@163.com");
        user.setAge(20);
        userMapper.insert(user);
        //mybatisplus会自动把当前插入对象在数据库中的id写回到该实体中
        System.out.println(user.getId());
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(2L);
        user.setName("更新测试1");
        //emplopyeeDao.updateById(employee);//根据id进行更新，没有传值的属性就不会更新
        userMapper.updateById(user);//根据id进行更新，没传值的属性就更新为null
    }


    /***
       *条件构造器 更新操作
       */

    @Test
    public void updateUser() {

        User user = new User();
        user.setName("xiao");
        user.setEmail("xxdd@baomidou.com");
        userMapper.update(user, new QueryWrapper<User>() {
        }.eq("id", 1));
    }


}

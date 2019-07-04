package com.jm.test.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jm.test.entiey.User;
import com.jm.test.service.UserService;
import com.jm.test.utils.APIResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author lyx
 * @date 2019/6/29 14:21
 */
@RestController
@RequestMapping(value = "/test")
@Api(value = "/test", tags = "测试")
public class TestController3 {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/test30", method = RequestMethod.POST)
    @ApiOperation(notes = "显示返回code和msg", httpMethod = "POST", value = "测试1", response = APIResponse.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param3", value = "参数1", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "param4", value = "参数2", dataType = "String", paramType = "query")
    })
    public Map<String, Object> test30(String param3, String param4) {
        Map<String, Object> map = new HashMap<>(10);
        List<User> userList = userService.list();
        map.put("code", "code");
        map.put("msg", "msg");
        map.put("data", userList);
        return map;
    }

    @RequestMapping(value = "/test31", method = RequestMethod.POST)
    @ApiOperation(notes = "显示返回code和msg", httpMethod = "POST", value = "测试1", response = APIResponse.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param3", value = "参数1", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "param4", value = "参数2", dataType = "String", paramType = "query")
    })
    public Map<String, Object> test31(String param3, String param4) {
        Map<String, Object> map = new HashMap<>(10);
        int count = userService.count();
        IPage<User> userIPage = new Page<>(1, 3,count);
        IPage<User> page = userService.page(userIPage,new QueryWrapper<User>()
                                 .between("age", 0, 100));
        System.out.println("返回数据："+userIPage.getRecords());

        System.out.println("总条数："+page.getTotal());

        System.out.println("当前页码："+page.getCurrent());

        System.out.println("总页码："+page.getPages());

        System.out.println("每页显示条数："+page.getSize());

//        System.out.println("是否有上一页："+page.hasPrevious());
//
//        System.out.println("是否有下一页："+page.hasNext());

        System.out.println("返回的数据："+page.getRecords());
        map.put("code", "code");
        map.put("msg", "msg");
        map.put("data", page);
        return map;
    }

}

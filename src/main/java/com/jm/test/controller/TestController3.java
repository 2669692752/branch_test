package com.jm.test.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jm.test.entity.User;
import com.jm.test.service.UserService;
import com.jm.test.utils.APIResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
//        int count = userService.count();
//        IPage<User> userPage = new Page<>(1, 3,count);
//        IPage<User> page = userService.page(userPage,new QueryWrapper<User>()
//                                 .between("age", 0, 100));

//        IPage<Map<String, Object>> page = userService.pageMaps(new Page<>(1, 2,count), new QueryWrapper<User>()
//                                 .between("age", 0, 100));
        IPage<User> page = userService.selectMethod();
        map.put("startPage", page.getCurrent() == 1);
        map.put("endPage",page.getCurrent()==page.getPages());
        map.put("everyPageSize",page.getSize());
        map.put("currentPage",page.getCurrent());
        map.put("totalSize",page.getTotal());
        map.put("allPage",page.getPages());
        map.put("code", "code");
        map.put("msg", "msg");
        map.put("data", page.getRecords());
        map.put("currentSize",page.getRecords().size());
        return map;
    }

}

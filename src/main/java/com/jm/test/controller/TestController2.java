package com.jm.test.controller;

import com.jm.test.utils.APIResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author lyx
 * @date 2019/6/29 14:08
 */
@RestController
@RequestMapping(value = "/test")
@Api(value = "/test", tags = "测试")
public class TestController2 {
    @RequestMapping(value = "/test20", method = RequestMethod.POST)
    @ApiOperation(notes = "显示返回code和msg", httpMethod = "POST", value = "测试1", response = APIResponse.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param3", value = "参数1", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "param4", value = "参数2", required = true, dataType = "String", paramType = "query")
    })
    public Map<String,Object> test20(String param3, String param4) {
        Map<String,Object> map=new HashMap<>(10);
        List<Object> list=new LinkedList<>();
        list.add(param3);
        list.add(param4);
        map.put("code","code");
        map.put("msg","msg");
        map.put("data",list);
        return map;
    }

}

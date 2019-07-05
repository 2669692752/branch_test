package com.jm.test.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jm.test.utils.APIResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Author lyx
 * @date 2019/6/29 14:08
 */
@RestController
@RequestMapping(value = "/test")
@Api(value = "/test", tags = "测试")
@Slf4j
public class TestController2 {
    @RequestMapping(value = "/test20", method = RequestMethod.POST)
    @ApiOperation(notes = "显示返回code和msg", httpMethod = "POST", value = "测试1", response = APIResponse.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "param3", value = "参数1", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "param4", value = "参数2", required = true, dataType = "String", paramType = "query")
    })
    public Map<String, Object> test20(String param3, String param4) {
        Map<String, Object> map = new HashMap<>(10);
        List<Object> list = new LinkedList<>();
        list.add(param3);
        list.add(param4);
        if (param3 == null) {
            param3 = "0";
        }
        BigDecimal bigDecimal = new BigDecimal(param3);
        map.put("bigDecimal", bigDecimal);
        log.info("origin = {}", param3);
        log.info("-------------开始时间{}-------------结束时间{}", param3, param4);
        map.put("uuid", 1);
        map.put("code", "code");
        map.put("msg", "msg");
        map.put("data", list);
        return map;
    }

    public static String formatPrice(BigDecimal bd, int num) {
        if (bd == null || num < 0) {
            return null;
        }
        bd = bd.setScale(num, BigDecimal.ROUND_HALF_UP);
        return bd + "";
    }

    public class MyRunnable implements Runnable {


//定义线程要执行的run方法逻辑

        @Override

        public void run() {


            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());

            }

        }

    }


    public static void main(String[] args) {

        JSONArray jSONArray1 = new JSONArray();
        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("name", "luo");
        jsonObject1.put("sex", "男");
        jSONArray1.add(jsonObject1);
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("name", "xing");
        jsonObject2.put("sex", "女");
        jSONArray1.add(jsonObject2);
        System.out.println("jSONArray1:" + jSONArray1);

        JSONArray jSONArray2 = new JSONArray();
        JSONObject jsonObject21 = new JSONObject();
        jsonObject21.put("name", "luolei");
        jsonObject21.put("sex", "男");
        jSONArray2.add(jsonObject21);
        JSONObject jsonObject22 = new JSONObject();
        jsonObject22.put("name", "dxx");
        jsonObject22.put("sex", "女");
        jSONArray2.add(jsonObject22);
        System.out.println("jSONArray2:" + jSONArray2);

        jSONArray2.addAll(jSONArray1);
        System.out.println("jSONArray2:" + jSONArray2);
        //结果
        /*jSONArray1:[{"name":"luo","sex":"男"},{"name":"xing","sex":"女"}]
        jSONArray2:[{"name":"luolei","sex":"男"},{"name":"dxx","sex":"女"}]
        jSONArray2:[{"name":"luolei","sex":"男"},{"name":"dxx","sex":"女"},{"name":"luo","sex":"男"},{"name":"xing","sex":"女"}]*/

    }


}

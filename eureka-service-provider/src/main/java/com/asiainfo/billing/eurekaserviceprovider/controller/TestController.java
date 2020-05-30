package com.asiainfo.billing.eurekaserviceprovider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * description: TestController <br>
 * date: 2020/3/18 11:47 <br>
 * author: YangRan <br>
 * version: 1.0 <br>
 */
@RestController
public class TestController {
    @RequestMapping("/getInfo")
    public String getDemoInfo(){
        return "this is a provider service";
    }

    @RequestMapping("/getString")
    public String getDemoInfo1(String userId){
        return userId+",this is a provider service";
    }

    @RequestMapping("/getMap")
    public Map<String,Object> getMap(){
        Map<String,Object> resultMap = new HashMap();
        resultMap.put("yangran","杨然");
        resultMap.put("xieli","谢丽");

        return resultMap;
    }
//    @RequestMapping("/getUser")
//    public User getUser(@RequestBody User user){
//        return user;
//    }

}
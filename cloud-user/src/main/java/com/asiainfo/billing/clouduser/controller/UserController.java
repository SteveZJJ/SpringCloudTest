package com.asiainfo.billing.clouduser.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.billing.clouduser.base.Response;
import com.asiainfo.billing.clouduser.base.ResponseData;
import com.asiainfo.billing.clouduser.model.UserInfo;
import com.asiainfo.billing.clouduser.service.UserInfoService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * description: UserController <br>
 * date: 2020/3/19 10:01 <br>
 * author: YangRan <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @PostMapping("/saveUserInfo")
    public ResponseData saveUserInfo(@RequestBody UserInfo userInfo) {
//        boolean flag = userInfoService.save(userInfo);
        return userInfoService.saveUserInfo(userInfo);
    }

    @GetMapping("/getUserInfoById")
    public ResponseData getUserInfoById(@RequestParam Map<String, String> params) {
        UserInfo userParam = new UserInfo();
        String userIdstring = "userId";
        userParam.setUserId(Integer.valueOf(params.get("userId")));
        UserInfo userInfo;
        if(redisTemplate.opsForValue().get(userIdstring+params.get(userIdstring))==null){
            userInfo = userInfoService.getById(userParam);
            redisTemplate.opsForValue().set(userIdstring+params.get("userId"),JSON.toJSONString(userInfo));
        }else {
            String userInfoString =  redisTemplate.opsForValue().get(userIdstring+params.get("userId"));
            userInfo =  JSON.parseObject(userInfoString,UserInfo.class);
        }
        return Response.success(userInfo);
    }

    @GetMapping("/getUserInfos")
    public ResponseData getUserInfos(Map<String, String> params) {
        Wrapper<UserInfo> queryUWrapper = new QueryWrapper<>();
        List<UserInfo> userInfoList = new ArrayList<>();
        if(redisTemplate.opsForValue().get("userList")==null){
            userInfoList = userInfoService.list(queryUWrapper);
            redisTemplate.opsForValue().set("userList",JSON.toJSONString(userInfoList));
        }else {
            String userInfoListString =  redisTemplate.opsForValue().get("userList");
            userInfoList = JSON.parseArray(userInfoListString,UserInfo.class);
        }
        return Response.success(userInfoList);
    }

    @GetMapping("/pageGetUserInfos")
    public ResponseData<IPage<UserInfo>> pageGetUserInfos(@RequestParam(value = "currentPage", defaultValue = "1") long currentPage,
                                                          @RequestParam(value = "pageSize", defaultValue = "5") long pageSize) {
        IPage<UserInfo> page = new Page<>(currentPage, pageSize);
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        IPage<UserInfo> result = userInfoService.page(page, queryWrapper);
        return Response.success(result);
    }

    @PostMapping("/saveBatchUsers")
    public ResponseData saveBatchUsers(@RequestBody List<UserInfo> userInfoList){
//        JSONObject json = JSON.parseObject(body);
//        List list = json.getJSONArray("");
//        userInfoService.saveBatch();
        userInfoService.saveBatch(userInfoList);
        return Response.success();
    }
}
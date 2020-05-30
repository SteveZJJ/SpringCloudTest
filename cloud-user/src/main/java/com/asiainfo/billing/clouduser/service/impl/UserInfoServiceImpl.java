package com.asiainfo.billing.clouduser.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.asiainfo.billing.clouduser.base.Response;
import com.asiainfo.billing.clouduser.base.ResponseData;
import com.asiainfo.billing.clouduser.model.UserInfo;
import com.asiainfo.billing.clouduser.dao.UserInfoMapper;
import com.asiainfo.billing.clouduser.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yangran
 * @since 2020-03-19
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;


    @Override
    public ResponseData saveUserInfo(UserInfo userInfo) {
        try {
            int nums = userInfoMapper.insert(userInfo);
        }catch (RuntimeException r){
            throw new RuntimeException(r);
        }

        return Response.success(true);
    }

    @Override
    public ResponseData saveBatchUsers(String userInfos) {
        JSONObject json = JSON.parseObject(userInfos);
        List list = json.getJSONArray("");

        return null;
    }

}

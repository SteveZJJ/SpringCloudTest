package com.asiainfo.billing.clouduser.service;

import com.asiainfo.billing.clouduser.base.ResponseData;
import com.asiainfo.billing.clouduser.model.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangran
 * @since 2020-03-19
 */
public interface UserInfoService extends IService<UserInfo> {


    ResponseData saveUserInfo(UserInfo userInfo);

    ResponseData saveBatchUsers(String userInfos);
}

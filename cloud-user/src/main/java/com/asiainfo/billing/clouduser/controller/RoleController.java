package com.asiainfo.billing.clouduser.controller;

import com.asiainfo.billing.clouduser.base.Response;
import com.asiainfo.billing.clouduser.base.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description: RoleController <br>
 * date: 2020/3/19 11:58 <br>
 * author: YangRan <br>
 * version: 1.0 <br>
 */
@RestController()
@RequestMapping("/role")
public class RoleController {

    @GetMapping("/getRole")
    public ResponseData getRole(){
        return Response.success(true);
    }
}
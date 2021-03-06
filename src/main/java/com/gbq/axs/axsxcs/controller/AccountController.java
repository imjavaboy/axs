package com.gbq.axs.axsxcs.controller;


import com.gbq.axs.axsxcs.config.jwt.JwtUtils;
import com.gbq.axs.axsxcs.pojo.Account;
import com.gbq.axs.axsxcs.pojo.ResBean;
import com.gbq.axs.axsxcs.pojo.WxUser;
import com.gbq.axs.axsxcs.service.AccountService;
import com.gbq.axs.axsxcs.utils.URLUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName AccountController
 * @Description TODO
 * @Author guobenqi
 * @Date 2022/1/20 20:38
 */
@Api(tags = "登录模块")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    @Autowired
    private JwtUtils jwtUtils;

    @ApiOperation("登录返回")
    @PostMapping("/login")
    public ResBean login(@RequestBody WxUser wxUser){
        System.out.println(wxUser);
        Map jsonObject = URLUtils.getOpenId(wxUser.getCode());
//        System.out.println(jsonObject);
//        System.out.println(jsonObject.get("openid"));
//        System.out.println(jsonObject.get("session_key"));
        String openid = (String) jsonObject.get("openid");
        String sessionKey = (String) jsonObject.get("session_key");



        Account account = accountService.selectByOpenId(openid);
        /*如果有用户*/
        if ( account == null){/*如果没有用户，入库*/
            account = new Account();
            account.setCity(wxUser.getCity());
            account.setHeadimg(wxUser.getAvatarUrl());
            account.setOpenId(openid);
            account.setSessionKey(sessionKey);
            account.setUsername(wxUser.getNickName());
            account.setSex(wxUser.getGender());
            account.setCreteTime(new Date());
            accountService.insertOne(account);
        }
        String token = jwtUtils.generateToken(account);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("token",token);
        map.put("account",account);

        return ResBean.success("登录成功",map);
    }


    @ApiOperation("登录返回")
    @PostMapping("/login/userpass")
    public ResBean loginByUser(@RequestBody Account wxUser){
//        System.out.println(wxUser);
        return accountService.loginByUser(wxUser);

    }

    @ApiOperation("获取用户信息")
    @GetMapping("/getAccount")
    public ResBean getAccount(Integer id){
        return accountService.getAccount(id);
    }

}

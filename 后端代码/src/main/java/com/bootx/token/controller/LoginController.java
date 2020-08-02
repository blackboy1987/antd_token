package com.bootx.token.controller;

import com.bootx.token.util.JWTUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    private String USERNAME="yunxiaocha";
    private String PASSWORD="yunxiaocha";

    @PostMapping("/account")
    public Map<String,Object> account(String userName,String type,String password){
        Map<String,Object> data = new HashMap<>();
        if(StringUtils.equals(userName,USERNAME)&&StringUtils.equals(password,PASSWORD)){
            data.put("status","ok");
            Map<String,Object> map = new HashMap<>();
            map.put("userName",userName);
            map.put("type",type);
            map.put("password",password);
            String token = JWTUtils.create("1",map);
            data.put("currentAuthority","admin");
            data.put("token",token);
        }else{
            data.put("status","error");
            data.put("msg","用户不存在！");
        }
        data.put("type",type);

        return data;
    }
}

package com.bootx.token.controller;

import com.bootx.token.util.JWTUtils;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class IndexController {

    @GetMapping("/currentUser")
    public Map<String,Object> currentUser(HttpServletRequest request){
        String token = request.getHeader("token");
        Claims claims = JWTUtils.parseToken(token);
        String userName = claims.get("userName", String.class);
        String type = claims.get("type", String.class);
        String id = claims.getId();
        Map<String,Object> data = new HashMap<>();
        data.put("id",id);
        data.put("userName",userName);
        data.put("type",type);
        return data;
    }
}

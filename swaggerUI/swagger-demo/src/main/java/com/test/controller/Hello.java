package com.test.controller;

import com.test.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@Api(tags = "Hello相关的请求")
public class Hello {
    @ApiOperation("你好返回接口")
    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }

    @PostMapping("/user")
    public User user(){
        return new User();
    }

    @PostMapping("/username")
    public String user( String a){
        System.out.println(a);
        return a+"hello";
    }
}

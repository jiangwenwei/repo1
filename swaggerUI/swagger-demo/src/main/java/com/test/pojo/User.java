package com.test.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

// @ApiModel("用户实体")
public class User {
    @ApiModelProperty("用户名")
    public  String userName;
    @ApiModelProperty("用户密码")
    public  String passWord;
}

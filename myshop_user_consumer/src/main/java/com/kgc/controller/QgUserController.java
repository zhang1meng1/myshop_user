package com.kgc.controller;

import com.kgc.dto.Dto;
import com.kgc.dto.DtoUtil;
import com.kgc.pojo.QgUser;
import com.kgc.service.QgUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Api(value = "用户模块",description = "处理用户操作")
public class QgUserController {
    @Autowired
    private QgUserService qgUserService;

 /*   @RequestMapping("/login")
    public Dto<QgUser> login( QgUser qgUser){
        try {
            return qgUserService.findUserLogin(qgUser.getPhone(),qgUser.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("fail","0000");
        }
    }*/

    @RequestMapping("/login")
    @ApiOperation(value = "用户登录",notes = "分页登录")
    @ApiImplicitParam(name ="qgUser",value = "用户json对象",required = true,dataType ="QgUser")
    public Dto<QgUser> login(@RequestBody QgUser qgUser){
        try {
            return qgUserService.findUserLogin(qgUser.getPhone(),qgUser.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            return DtoUtil.returnFail("fail","0000");
        }


    }
}

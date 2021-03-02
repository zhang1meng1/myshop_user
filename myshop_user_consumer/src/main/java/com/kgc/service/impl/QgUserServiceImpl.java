package com.kgc.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kgc.dto.Dto;
import com.kgc.dto.DtoUtil;
import com.kgc.pojo.QgUser;
import com.kgc.service.QgUserService;
import com.kgc.service.RpcUserService;
import org.springframework.stereotype.Service;

@Service
public class QgUserServiceImpl implements QgUserService {
    @Reference
    private RpcUserService rpcUserService;

    @Override
    public Dto<QgUser> findUserLogin(String phone, String password) throws Exception {
        if(phone==null || phone=="" || password== null || password== ""){
            return DtoUtil.returnFail("fail","0002");
        }
        //调用服务方法
        QgUser user=rpcUserService.findUserLogin(phone,password);
        if(user!=null){
            return DtoUtil.returnSuccess("ok",user);
        }else {
            return DtoUtil.returnFail("fail","0001");
        }
    }
}

package com.kgc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.kgc.mapper.QgUserMapper;
import com.kgc.pojo.QgUser;
import com.kgc.service.RpcUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RpcUserServiceImpl implements RpcUserService {
    @Autowired
    private QgUserMapper qgUserMapper;
    @Override
    public QgUser findUserLogin(String phone, String password) throws Exception {
        QgUser qgUser=null;
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("phone",phone);
        map.put("password",password);
        //调用mapper的方法
        List<QgUser> list = qgUserMapper.getQgUserListByMap(map);
        if(list!=null && list.size()>0) {
            return list.get(0);
        }
        return null;
    }
}

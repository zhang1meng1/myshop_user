package com.kgc.service;

import com.kgc.dto.Dto;
import com.kgc.pojo.QgUser;

public interface QgUserService {
    public Dto<QgUser> findUserLogin(String phone,String password) throws Exception;
}

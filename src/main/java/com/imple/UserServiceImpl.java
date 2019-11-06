package com.imple;

import com.service.IUserService;

public class UserServiceImpl implements IUserService {

    private int count=0;//作为登陆统计
    @Override
    public boolean isExit() {
        return this.count>=3;//执行登陆退出的条件
    }

    @Override
    public boolean login(String name, String password) {
        count++;
        return  ("mldn".equals(name)&&"hello".equals(password));
    }
}

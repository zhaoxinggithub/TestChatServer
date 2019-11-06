package com.factory;


import com.imple.UserServiceImpl;
import com.proxy.UserServiceProxy;
import com.service.IUserService;

public class IUserFactory {
    private IUserFactory(){}
    public static IUserService getInstance(){
        return new UserServiceProxy(new UserServiceImpl());
    }

}

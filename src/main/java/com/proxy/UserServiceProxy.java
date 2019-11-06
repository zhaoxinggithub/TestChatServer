package com.proxy;

import com.service.IUserService;
import com.util.InputUtil;

public class UserServiceProxy implements IUserService {
    private IUserService userService;

    public UserServiceProxy(IUserService iUserService){
        this.userService=iUserService;
    }
    @Override
    public boolean isExit() {
        return this.userService.isExit();
    }

    @Override
    public boolean login(String name, String password) {
        while(!isExit()) {
            String inputData = InputUtil.getString("请输入登陆信息:");
            if (inputData.contains("/")) {//输入了用户名和密码
                String tmp[] = inputData.split("/");
                if (this.userService.login(tmp[0], tmp[1])) {
                    return true;
                } else {
                    System.out.println("登陆失败，错误的用户名或密码");
                }
            } else {//现在只有用户名
                String pwd = InputUtil.getString("请输入密码：");
                if (this.userService.login(inputData, pwd)) {
                    return true;
                } else {
                    System.out.println("登陆失败，错误的用户名或密码！");
                }

            }
        }
        return false;
    }
}

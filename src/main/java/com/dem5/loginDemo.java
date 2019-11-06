package com.dem5;

import com.factory.IUserFactory;

public class loginDemo
{
    public static void main(String[] args){
        System.out.println(IUserFactory.getInstance().login(null,null));
    }
}

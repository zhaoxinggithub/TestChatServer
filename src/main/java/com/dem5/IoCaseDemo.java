package com.dem5;

import com.factory.Factory;
import com.service.INumberService;

public class IoCaseDemo {
    public static void main(String[] args){
        INumberService im= Factory.getInstance();
        int result[]=im.stat(3);
        System.out.println("最大值："+result[0]+",最小值："+result[1]);
    }
}

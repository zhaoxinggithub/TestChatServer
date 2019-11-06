package com.menu;

import com.factory.StudentFactory;
import com.service.IStudentService;
import com.util.InputUtil;

import java.util.Arrays;

public class NumberMenu {
    public NumberMenu(){
        this.choose();
    }
    public void choose(){
        this.show();
        String choose= InputUtil.getString("请选择：\n");
        switch (choose){
            case "1":{
                String str=InputUtil.getString("请进行选择：");
                choose();//重复出现

            }
            case "2":{//逆序显示数据

                choose();//重复出现

            }
            case "0":{
                System.out.println("下次再见");
                System.exit(1);
            }
            default:{
                System.out.println("您输入非法数据请你重新输入\n");
                choose();
            }
        }
    }
    public void show(){
        System.out.println("[0] 结束程序执行\n");
        System.out.println("[1] 追加实体数据\n");
        System.out.println("[2] 显示所有的数据\n");
        System.out.println("\n\n\n");
    }
}

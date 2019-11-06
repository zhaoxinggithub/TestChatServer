package com.menu;

import com.factory.AppendFactory;
import com.factory.FactorIO;
import com.service.IStringService;
import com.util.InputUtil;

import java.util.Arrays;

public class Menu {
    private IStringService iStringService;
    public Menu(){
        this.iStringService=AppendFactory.getInstance();
        choose();
    }
    public void choose(){
        this.show();
        String choose= InputUtil.getString("请选择：\n");
        switch (choose){
            case "1":{
                String str=InputUtil.getString("请输入字符串数据：");
                this.iStringService.append(str);
                choose();//重复出现

            }
            case "2":{//逆序显示数据
                String result[]=this.iStringService.reverse();
                System.out.println(Arrays.toString(result));
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
        System.out.println("[1] 追加字符串数据\n");
        System.out.println("[2] 逆序显示所有的字符串数据\n");
        System.out.println("\n\n\n");
    }
}

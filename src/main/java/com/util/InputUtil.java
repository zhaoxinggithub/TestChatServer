package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class InputUtil {
    static BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
    private InputUtil(){}
//    private static final Scanner INPUT=new Scanner(System.in);
    public static int getInt(String prompt){
        int num=0;
        boolean flag=true;
        while(flag) {
            Scanner input=new Scanner(System.in);
            System.out.println(prompt);//打印提示信息作为监督输入情况
//            if (INPUT.hasNext()) {
                if(input.hasNext("\\d+")){
                flag=false;
//                num=INPUT.nextInt();
                    num=Integer.parseInt(input.next("\\d+"));
            }else{
                System.out.println("输入的内容不是数字");
            }
        }
        return num;
    }

    public static int getIntBUF(String prompt){

        int num=0;
        boolean flag=true;
        while(flag) {
            System.out.println(prompt);//打印提示信息作为监督输入情况
            String str=null;
            try {
                str=buf.readLine();
                if(str.matches("\\d+")){
                    num=Integer.parseInt(str);
                    flag=false;
                }else{
                    System.out.println("输入的内容不是数字");
                }
            } catch (IOException e) {
                System.out.println("输入的内容不是数字");
            }
        }
        return num;
    }

    public static String getString(String prompt){
        String str=null;
        boolean flag=true;
        while(flag){
            Scanner input=new Scanner(System.in);
            System.out.print(prompt);
            try {
                str=buf.readLine();
                if(!"".equals(str)){//不是空串
                    flag=false;
                }else{
                    System.out.println("输入内容不容许为空！");
                }
            } catch (IOException e) {
                System.out.println("输入内容不容许为空！");
            }
//            if(input.hasNext()){
//                str=input.next().trim();
//                if(!"".equals(str)){//不是空串
//                    flag=false;
//                }else{
//                    System.out.println("输入内容不容许为空！");
//                }
//            }else{
//                System.out.println("输入内容不容许为空！");
//            }
        }
        return str;
    }

}

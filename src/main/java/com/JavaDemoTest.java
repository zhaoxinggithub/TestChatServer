package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class JavaDemoTest {
    public static void main(String[] args) throws IOException {
//        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入信息：");
//        String msg=input.readLine();
        while(scan.hasNext()){
            String msg=scan.next();
            System.out.println(msg);
        }
        scan.hasNext();
    }
}

package com.demo35;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private static final BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws Exception{
        Socket client=new Socket("localhost",9999);
        //现在端客户端输入与输出端操作支持，所以依然要准备出Scanner 与PrintWriter
        Scanner scan=new Scanner(client.getInputStream());//接收服务器端输入内容
        scan.useDelimiter("\n");
        PrintStream out=new PrintStream(client.getOutputStream());//向服务器发送内容
        boolean flag=true;
        while (flag){
         String input=getString("请输入要发送端内容：").trim();
         out.println(input);//加换行
            if(scan.hasNext()){
                System.out.println(scan.next());
            }
             if("byebye".equalsIgnoreCase(input)){
                 flag=false;
            }
        }
        client.close();
        out.close();
        scan.close();

    }
    public static String getString(String prompt) throws Exception{
        System.out.println(prompt);
        String str=buf.readLine();
        return str;
    }
}

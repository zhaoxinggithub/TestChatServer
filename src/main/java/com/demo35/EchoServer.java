package com.demo35;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private static class ClientThread implements Runnable{
        private Socket client=null;//描述每一个不同的客户端
        private Scanner scan=null;
        private PrintStream out=null;
        boolean flag=true;
        public ClientThread(Socket client) throws Exception{
            this.client=client;
            this.scan = new Scanner(client.getInputStream());//客户端输入
            this.scan.useDelimiter("\n");
           this.out = new PrintStream(client.getOutputStream());//客户端输出
        }

        @Override
        public void run() {
            while (this.flag) {
                if (scan.hasNext()) {
                    String val = scan.next().trim();
                    if ("byebye".equalsIgnoreCase(val)) {
                        out.println("ByeBye..");
                        this.flag = false;
                    } else {
                        out.println("[ECHO]"+val);
                    }
                }


            }
            try {
                scan.close();
                out.close();
                client.close();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9999);
        System.out.println("等待客户连接...");

        boolean flag=true;
        while(flag){
            Socket client = server.accept();//有客户端连接
            new Thread(new ClientThread(client)).start();
        }
        server.close();


    }
}

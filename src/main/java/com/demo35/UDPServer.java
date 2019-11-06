package com.demo35;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws  Exception{
        DatagramSocket server=new DatagramSocket(9000);//连接到9999端口
        String str="www.mldn.cn";//要发送到消息内容
        DatagramPacket packet=new DatagramPacket(str.getBytes(),0,str.length(),InetAddress.getByName("localhost"),9999);//发送数据
        server.send(packet);
        System.out.println("服务器运行后消息发送完毕。。。");
        server.close();
    }
}

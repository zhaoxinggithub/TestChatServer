package com.demo35;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClient {
    public static void main(String[] args) throws Exception{
        DatagramSocket client=new DatagramSocket(9999);//连接到9999端口
        byte data[]=new byte[1024];//接收到消息
        DatagramPacket  packet=new DatagramPacket(data,data.length);//接收数据
        System.out.println("客户端等待接收发送端消息。。");
        client.receive(packet);
        System.out.println("接收到的消息内容为："+new String(data,0,packet.getLength()));
        client.close();
    }
}

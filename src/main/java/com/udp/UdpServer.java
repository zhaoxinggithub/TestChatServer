package com.udp;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket server = new DatagramSocket(Integer.parseInt("8888"));
        byte[] contain=new byte[1024];
        DatagramPacket packet=new DatagramPacket(contain,contain.length);
        server.receive(packet);
//        byte[] data=packet.getData();
//        System.out.println(new String(data,0,packet.getLength()));
        double num=convert(packet.getData());
        server.close();
        System.out.println(num);
    }
    public static double convert(byte[] bytes){
        DataInputStream is=new DataInputStream(new ByteArrayInputStream(bytes));
        double num=0;
        try {
            num=is.readDouble();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return num;
    }

}

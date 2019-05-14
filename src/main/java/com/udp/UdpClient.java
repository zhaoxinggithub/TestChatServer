package com.udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpClient {
    public static void main(String[] args) throws IOException {

        DatagramSocket client=new DatagramSocket(Integer.parseInt("6666"));
//        String ss="hello world";
          double num=89.0;
          byte[] bytes=convert(num);
//        byte[] bytes=ss.getBytes();
        DatagramPacket datagramPacket=new DatagramPacket(bytes,0,bytes.length,new InetSocketAddress("localhost",8888));
        client.send(datagramPacket);
        client.close();

    }

    public static byte[] convert(double num){
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        DataOutputStream os=new DataOutputStream(bos);
        byte[] bytes=new byte[1024];
        try {
            os.writeDouble(num);
            os.flush();

            bytes=bos.toByteArray();


        } catch (IOException e) {
            e.printStackTrace();
        }


        return bytes;
    }
}

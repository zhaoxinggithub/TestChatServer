package com.multcp;

import java.io.*;
import java.net.Socket;

public class ClientTest {
    public static void main(String[] args) throws Exception{

        Socket socket=new Socket("localhost",8888);
//        DataInputStream dis=new DataInputStream(System.in);
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        DataOutputStream os=new DataOutputStream(socket.getOutputStream());
//        DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
//        String msg="发送信息";

            new Thread(new Send(socket)).start();
            new Thread(new Recieve(socket)).start();

//        while(true) {
//            String msg = reader.readLine();
//            os.writeUTF(msg);
//            os.flush();
//
//            String resmsg = dataInputStream.readUTF();
//            System.out.println(resmsg);
//        }
    }
}

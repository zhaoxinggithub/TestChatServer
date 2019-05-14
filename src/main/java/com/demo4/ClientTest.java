package com.demo4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientTest {
    public static void main(String[] args) throws Exception{

        Socket socket=new Socket("localhost",9999);
//        DataInputStream dis=new DataInputStream(System.in);
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        DataOutputStream os=new DataOutputStream(socket.getOutputStream());
//        DataInputStream dataInputStream=new DataInputStream(socket.getInputStream());
//        String msg="发送信息";
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String inputstr=br.readLine();
        if(""==inputstr){
            return;
        }
            new Thread(new Send(socket,inputstr)).start();
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

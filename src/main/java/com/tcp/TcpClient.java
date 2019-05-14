package com.tcp;

import java.io.*;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("localhost",8888);
        /*BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String str=reader.readLine();*/
        DataInputStream is=new DataInputStream(socket.getInputStream());
        System.out.println(is.readUTF());

    }
}

package com.tcp;

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server=new ServerSocket(8888);
        Socket socket=server.accept();
        System.out.println("一个链接");
        String msg="发送信息";
/*        BufferedWriter bs=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bs.write(msg);
        bs.flush();*/
        DataOutputStream os=new DataOutputStream(socket.getOutputStream());
        os.writeUTF(msg);
        os.flush();
    }
}

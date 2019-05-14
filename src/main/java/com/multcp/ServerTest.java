package com.multcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket socket = server.accept();
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String msg = "服务器-->" + is.readUTF();
                os.writeUTF(msg);
                os.flush();
            }
        }
    }
}

package com.demo3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    List<MyThread> all=new ArrayList<MyThread>();
    public static void main(String [] args){
        new Server().start();
    }
    public void start(){
        ServerSocket server = null;
        try {
            server = new ServerSocket(9999);
            while(true) {
                Socket socket = server.accept();
                MyThread myThread = new MyThread(socket);
                all.add(myThread);
                new Thread(myThread).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    class MyThread implements Runnable {
        private DataInputStream dis;
        private DataOutputStream os;
        private boolean isRunning = true;

        public MyThread(Socket client) {
            try {
                dis = new DataInputStream(client.getInputStream());
                os = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                isRunning = false;
            }
        }

        public void send(String msg) {
            if (null != msg && "" != msg) {
                try {
                    os.writeUTF(msg);
                    os.flush();
                } catch (IOException e) {
//                    e.printStackTrace();
                    isRunning = false;
                    CloseUtil.closeAll(dis, os);
                    all.remove(this);
                }
            }

        }

        public String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
//               return msg;
//                System.out.println(str);
            } catch (IOException e) {
//                e.printStackTrace();
                isRunning = false;
                CloseUtil.closeAll(dis, os);
                all.remove(this);
            }
            return msg;
        }

        public void sendOther() {
            String msg=this.receive();
            for(MyThread other:all){
                if(this==other){
                    continue;
                }
                other.send(msg);
            }
        }


        public void run() {
            while (isRunning) {
                sendOther();
            }
        }
    }
}

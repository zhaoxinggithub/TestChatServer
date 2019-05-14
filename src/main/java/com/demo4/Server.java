package com.demo4;

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
        private String name;
        private boolean sys;
        public MyThread(Socket client) {
            try {
                dis = new DataInputStream(client.getInputStream());
                os = new DataOutputStream(client.getOutputStream());
                this.name=dis.readUTF();
                sys=true;
                this.send("欢迎进入聊天教室");
                sendOther(this.name+"欢迎进入聊天室",true);
            } catch (IOException e) {
                e.printStackTrace();
                isRunning = false;
            }
        }

        public void send(String msg) {
            if (null == msg || "" == msg)
            {
              return ;
            }else {
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
            } catch (IOException e) {
//                e.printStackTrace();
                isRunning = false;
                CloseUtil.closeAll(dis, os);
                all.remove(this);
            }
            return msg;
        }

        public void sendOther(String msg,boolean syslocal) {
            //确认私自聊天
            if(msg.startsWith("@")&&msg.indexOf(":")>-1){
              String   localname=msg.substring(1,msg.indexOf(":"));
                String localcontent=msg.substring(msg.indexOf(":")+1);
                for(MyThread other:all){
                    if(other.name.equals(localname)){
                        other.send(this.name+"客户"+localname+"悄悄对你说"+localcontent);
                    }
                }
            }else {
                for (MyThread other : all) {
                    if (this == other) {
                        continue;
                    }
                    if(syslocal){
                     other.send("系统："+msg);
                    }else {
                        other.send("聊天室的信息内容："+msg);
                    }
                }
            }
        }


        public void run() {
            while (isRunning) {
                sendOther(receive(),false);
//                send();
            }
        }
    }
}

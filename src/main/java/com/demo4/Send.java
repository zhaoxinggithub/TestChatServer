package com.demo4;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable {
    private BufferedReader reader;
    private DataOutputStream os;
    private boolean running=true;
    private String name;

        public Send(){
//            this.running=true;
            reader=new BufferedReader(new InputStreamReader(System.in));
        }

        public  Send(Socket socket, String inputstr){
            this();
            this.name=inputstr;
            try {
                os = new DataOutputStream(socket.getOutputStream());
                send(this.name);
            }catch(Exception e){
                this.running=false;
                CloseUtil.closeAll(new Closeable[]{this.reader,this.os});
            }
        }
        public void send(String msg){

                try {
                    if(msg!=""&&null!=msg) {
                        os.writeUTF(msg);
                        os.flush();
                    }
                } catch (Exception e) {
                    this.running = false;
                    CloseUtil.closeAll(new Closeable[]{this.reader,this.os});
                }
        }
        public String getMessage(){
            try {
                return reader.readLine();
            }catch(Exception e){
//                return "";
            }
            return "";
        }

    public void run() {
            while(this.running){
                send(getMessage());
            }
    }
}

package com.multcp;

import java.io.*;
import java.net.Socket;

public class Send implements Runnable {
    private BufferedReader reader;
    private DataOutputStream os;
    private boolean running=true;
        public Send(){
//            this.running=true;
            reader=new BufferedReader(new InputStreamReader(System.in));
        }

        public  Send(Socket socket){
            this();
            try {
                os = new DataOutputStream(socket.getOutputStream());
            }catch(Exception e){
                this.running=false;
                CloseUtil.closeAll(new Closeable[]{this.reader,this.os});
            }
        }
        public void send(){
                try {

                    String msg = getMessage();
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
                send();
            }
    }
}

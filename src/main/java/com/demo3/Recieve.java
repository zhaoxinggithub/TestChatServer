package com.demo3;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Recieve implements Runnable{
    private DataInputStream dataInputStream;
    private boolean running=true;
    public Recieve(){

//        this.running=true;
    }
    public Recieve(Socket socket){
        try {
            dataInputStream=new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            this.running=false;
            CloseUtil.closeAll(this.dataInputStream);
        }
    }
    public  String receive(){
        String str="";
        try {
            str=this.dataInputStream.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
            this.running=false;
            CloseUtil.closeAll(this.dataInputStream);
        }
        return str;
    }
    public void run() {
    while(running){
        System.out.println(receive());
    }
    }


}

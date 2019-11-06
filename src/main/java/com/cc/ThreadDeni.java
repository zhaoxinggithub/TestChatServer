package com.cc;

class Message{
    private String title;
    private String content;
    public synchronized void set(String title,String content){
        this.title=title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content=content;
    }
    public synchronized String get(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.title+"-"+this.content;
    }
}
class Producer implements Runnable{
    private Message msg;
    public Producer(Message msg){
        this.msg=msg;
    }
    public void run(){
        for(int x=0;x<1000;x++){
            if(x%2==0){
                this.msg.set("王健","宇宙大帅哥");
            }else{
                this.msg.set("小高","猥琐第一人，常态保持");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
class Consumer implements Runnable{
    private Message msg;
    public Consumer(Message msg){
        this.msg=msg;
    }
    public void run(){
        for(int i=0;i<1000;i++){
            System.out.println(this.msg.get());
        }
    }
}
public class ThreadDeni {
    public static void main(String [] args){
        Message msg=new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }
}

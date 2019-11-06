package com.consumer;

public class ThreadTest {
    private static boolean flag=true;
    public static  void main(String[] args){
        new Thread(()->{
            long num=0;
            while(flag){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+" num="+num++);
            }
        },"执行线程").start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag=false;

    }

}

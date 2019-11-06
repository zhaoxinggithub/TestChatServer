package com.dem5;

public class JAVAAIPDemo {
    public static void main(String[] args) {
        for(int i=0;i<3;i++){
            new Thread(){
                @Override
                public void run() {
                    SingleInstance.getInstance().print();
                    super.run();
                }
            }.start();
        }
    }

}
class SingleInstance {
    private static volatile SingleInstance singleInstance =null;
    private SingleInstance(){
        System.out.println("["+Thread.currentThread().getName()+"]"+"***实例化代码快");
    }
    public static  SingleInstance getInstance(){
            if (singleInstance == null) {
             synchronized (SingleInstance.class) {
                 if(singleInstance==null) {
                     singleInstance = new SingleInstance();
                 }
            }
        }
        return singleInstance;
    }
        public void print(){
        System.out.println("调用方法输出");
        }

        }

package com.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args){
        Corable core=new Corable();
        FutureTask<String> futureTaskA=new FutureTask<String>(core);
        FutureTask<String> futureTaskB=new FutureTask<String>(core);
        FutureTask<String> futureTaskC=new FutureTask<String>(core);
        new Thread(futureTaskA,"竞赛者A").start();
        new Thread(futureTaskB,"竞赛者B").start();
        new Thread(futureTaskC,"竞赛者C").start();
        try {
            System.out.println(futureTaskA.get());
            System.out.println(futureTaskB.get());
            System.out.println(futureTaskC.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
class Corable implements Callable<String>{
    private boolean flag=false;
    @Override
    public String call() throws Exception {
        synchronized (this){
            if(this.flag == false){
                this.flag=true;
                return Thread.currentThread().getName()+"抢答成功！";
            }else{
                return Thread.currentThread().getName()+"抢答失败！";
            }
        }
    }
}


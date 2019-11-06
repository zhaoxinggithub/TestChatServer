package com.dem5;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

interface IService{
    void service();
}
class HouseService implements IService{

    @Override
    public void service() {
        System.out.println("service 调用");
    }
}
interface IMessage{
    public void send();//消息发送
}
class NetMessage implements IMessage{


    @Override
    public void send() {
        System.out.println("网络消息发送成功！");
    }
}
class CloudMessage implements  IMessage{

    @Override
    public void send() {
        System.out.println("云消息发送成功");
    }
}
class Factory{
    private Factory(){}
/*    public static IMessage getInstance(String className){
        IMessage instance=null;
        try {
            instance=(IMessage) Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }*/
        public static <T>T getInstance(String className,Class<T> clazz){
            T instacne=null;
            try {
                instacne=(T)Class.forName(className).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return instacne;
        }
}
public class APIDemo {
    public static void main(String[] args) {

        method();

    }

    private static void method() {
        List arraylist=new ArrayList<Integer>();
        for(Object s:arraylist){
            if(s.equals(1)){
                arraylist.remove(s);
            }
        }


    }

}

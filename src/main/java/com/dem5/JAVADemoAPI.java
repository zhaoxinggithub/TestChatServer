package com.dem5;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class JAVADemoAPI {
    public static void main(String[] args) throws NoSuchMethodException {
        //获取接口上的Annotion
        {
            Annotation annotations[] = IMessagek.class.getAnnotations();
            for (Annotation temp : annotations) {
                System.out.println(temp);
            }
        }
        System.out.println("----------------------------");
        {//获取MessageImpl子类上的Annotation
            Annotation annotations[] = MessageImpl.class.getAnnotations();
            for (Annotation temp : annotations) {
                System.out.println(temp);
            }
        }
        System.out.println("----------------------------");
        {//获取MessageImpl.toString()方法上的Annotation
            Method method=MessageImpl.class.getDeclaredMethod("send",String.class);
            Annotation annotations[] =method.getAnnotations();//获取接口上的全部Annotation
            for (Annotation temp : annotations) {
                System.out.println(temp);
            }
        }
    }
}
@FunctionalInterface
@Deprecated()
interface IMessagek{//有两个Annotation
    public void send(String msg);

}
@SuppressWarnings("serial")
class MessageImpl implements IMessagek, Serializable{
    @Override
    public void send(String msg) {
        System.out.println("消息发送"+msg);
    }
}


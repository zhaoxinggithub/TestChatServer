package com.demo27;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaAPIDemoFactory {
    public static void main(String[] args) {
        //第一种
 /*   IMessage msg=Factory.getInstance(IMessageImpl.class);
    msg.send("ww.wlndn");*/

 MessageService messageService=new MessageService();
 messageService.send("www.mldn.cn");
    }
}
@Retention(RetentionPolicy.RUNTIME)
@interface UseMessage{
    public Class<?> clazz();
}
@UseMessage(clazz = IMessageImpl.class) //利用Annotation 实现类类的使用
class MessageService{
    private IMessage message;
    public MessageService(){
//        this.message=Factory.getInstance(IMessageImpl.class);
        UseMessage use=MessageService.class.getAnnotation(UseMessage.class);
        this.message=(IMessage) Factory.getInstance(use.clazz());//直接通过Annotatin或取
    }
    public void send(String msg){
        this.message.send(msg);
    }
}
class Factory{
    private Factory(){}
    public static <T> T getInstance(Class<T> clazz){
        try {
            return (T)new MessageProxy().bind(clazz.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
class MessageProxy implements InvocationHandler{
    private Object target;
    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
public boolean connect(){
    System.out.println("代理操作    进行消息发送的连接");
    return true;
 }
 public void close(){
     System.out.println("代理操作     关闭连接通道");
 }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (this.connect()) {
                return method.invoke(this.target, args);
            } else {
                throw new Exception("ERROR 消息无法进行发送");
            }
        }finally {
            this.close();
        }
    }
}
interface IMessage{
    public void send(String msg);
}
class IMessageImpl implements  IMessage, Serializable{

    @Override
    public void send(String msg) {
        System.out.println("消息发送"+msg);
    }
}

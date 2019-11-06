package com.dem5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class InvocationDemo {
    public static void main(String[] args){
        IMessagel msg= (IMessagel) new MLDNProxy().bind(new MessageReal());
        msg.send();
    }

}
class MLDNProxy implements InvocationHandler{
    private Object target;//保存真实业务对象
    public Object bind(Object target){
        this.target=target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行方法"+method);
        Object returnData=null;
        if(this.connect()){
            returnData=method.invoke(this.target,args);
            this.close();
        }
        return returnData;
    }
    public void close(){
        System.out.println("消息代理关闭消息通道");
    }
    public boolean connect(){
        System.out.println("进行消息发送通道的连接");
        return true;
    }
}
interface IMessagel{ //传统代理设计必须有接口
    public void send();//业务方法
}
class MessageReal implements IMessagel{

    @Override
    public void send() {
        System.out.println("发送信息 www.mldn.cn");
    }
}

package com.demo27;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * 设置自定义的类
 */
public class JavaAPIDemo {
    public static void main(String[] args) throws Exception {
        Method method=Message.class.getMethod("send",String.class);//获取指定方法
        DefaultAnnotation anno=method.getAnnotation(DefaultAnnotation.class);//获取指定的Annotation
//        System.out.println(anno.title());//直接调用Annotation中的方法
//        System.out.println(anno.url());//直接调用Annotation中的方法

        String msg=anno.title()+"("+anno.url()+")";//消息内容
        method.invoke(Message.class.getDeclaredConstructor().newInstance(),msg);
    }
}
@Retention(RetentionPolicy.RUNTIME)
@interface DefaultAnnotation{
    public String title();//获取数据
    public String url() default "www.mldn.cn";//获取数据，默认值
}
class Message{
    @DefaultAnnotation(title="MLDN")
    public void send(String msg){
        System.out.println("消息发送"+msg);
    }
}

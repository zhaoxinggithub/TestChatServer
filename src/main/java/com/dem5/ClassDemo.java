package com.dem5;


//import com.consumer.PersonOk;

import java.lang.reflect.InvocationTargetException;

public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        Person personl=new Person();
//        Class<?> cls = personl.getClass();
//        System.out.println("1："+cls.getName());

        Class<Person> cls2 = Person.class;
        System.out.println(cls2.getName());

        Class<?> cls3 = Class.forName("com.consumer.PersonOk");
//       Object obj= cls3.newInstance();
        Object obj= cls3.getDeclaredConstructor().newInstance();//调用默认无参的构造方法
        System.out.println(obj);

    }
}

package com.dem5;

import java.lang.reflect.Method;

import static com.sun.tools.classfile.AccessFlags.Kind.Method;

public class JavaAPIDemoNormalFunction {
    public static void main(String[] args) throws Exception {
      Class <?>clz=  Class.forName("com.factory.Person");//获取指定的class对象
        String value="小强着";
        //1 任何时候需要保存类属性或者方法必须获取类的实力化对象，既然不容许导包，那么就反射实例化
        Object obj=clz.getDeclaredConstructor().newInstance();
        //2 如果想进行方法的调用，必须获取方法的名称
        String setMethodName="setName";
        java.lang.reflect.Method setmethod=clz.getDeclaredMethod(setMethodName,String.class);//获取指定的方法
        setmethod.invoke(obj,value);//等价于，Person对象，setName(value);
        String getMethodName="getName";
        Method getMethod=clz.getDeclaredMethod(getMethodName);//
        System.out.println(getMethod.invoke(obj));


    }
}

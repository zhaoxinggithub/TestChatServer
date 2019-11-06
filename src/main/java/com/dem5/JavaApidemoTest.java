package com.dem5;

import com.factory.Person;

import java.lang.reflect.*;

public class JavaApidemoTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Class<?> personClass = Person.class;
//        Package pck=personClass.getPackage();
//        System.out.println(pck.getName());

       /* Class<?> parent = personClass.getSuperclass();
       /* Class<?> parent = personClass.getSuperclass();
        System.out.println(parent.getName());
        System.out.println(parent.getSuperclass().getName());
        System.out.println(parent.getSuperclass().getSuperclass());*/

/*       Class<?> cla[] =personClass.getInterfaces();
       for(Class tmp:cla){
           System.out.println(tmp.getName());
       }*/


//        Constructor<?> []constructor = personClass.getConstructors();
/*        Constructor<?> []constructor = personClass.getDeclaredConstructors();
        for(Constructor<?> tmp:constructor){
            System.out.println(tmp);
        }*/



  /*          Constructor <?> constructor=personClass.getConstructor(String.class,int.class);
            Object obj=constructor.newInstance("里斯",22);
        System.out.println(obj.toString());*/


  //通过反射获取方法的普通东西
/*        Method[]method=personClass.getMethods();
        for(Method met:method){
            System.out.println(met);
        }

        System.out.println("------获取所有的方法 下面获取所有的自定义方法");
        Method [] methods=personClass.getDeclaredMethods();
        for(Method mm:methods){
            System.out.println(mm);
        }*/
//        metdhod1()
        ;
        try {
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过反射获取普通的方法返回类型 等
     */
    public static void metdhod1(){
        Class<?> personClass = Person.class;
        Method[]method=personClass.getMethods();
        for(Method met:method){
            int mod=met.getModifiers();//修饰符
            System.out.print(Modifier.toString(mod)+" ");
            System.out.print(met.getReturnType().getName()+" ");
            System.out.print(met.getName()+"(");
            Class<?>[] clz=met.getParameterTypes();//获取参数类型
            for(int x=0;x<clz.length;x++){
                System.out.print(clz[x].getName()+" "+"args-"+x);
                if(x<clz.length-1){
                    System.out.print(",");
                }
            }
            System.out.print(")");
            Class<?> exp[]=met.getExceptionTypes();
            if(exp.length<0){
                System.out.print(" throws");
            }
            for(int x=0;x<exp.length;x++){
                System.out.println(exp[x].getName());
                if(x<exp.length-1){
                    System.out.print(",");
                }
            }
            System.out.println("");

        }
    }

    /**
     * 获取实例化 成员 设置方法
     */
    public static void method2() throws Exception {
        Class<?> clz=Class.forName("com.factory.Person");
        Object obj=clz.getDeclaredConstructor().newInstance();
        Field nameField=clz.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj,"王功");
        System.out.println(nameField.get(obj));


        System.out.println(nameField.getType().getName());
        System.out.println(nameField.getType().getSimpleName());

    }

}

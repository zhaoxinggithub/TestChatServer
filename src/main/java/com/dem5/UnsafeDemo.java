package com.dem5;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnsafeDemo {
    public static void main(String[] args) throws Exception{
        Field filed= Unsafe.class.getDeclaredField("theUnsafe");
        filed.setAccessible(true);//减除封装
        Unsafe unsafeObject= (Unsafe) filed.get(null);//static 属性不需要传递实例化参数
        //利用unsafe 绕过jvm内存管理，或得实例化对象不需要 不是必须不建议使用。
        Singleton instance= (Singleton) unsafeObject.allocateInstance(Singleton.class);
        instance.print();
    }
}
class Singleton{
    private Singleton(){
        System.out.println("**********Singleton类构造 *********");
    }
    public void print(){
        System.out.println("www.mldn.cn");
    }

}

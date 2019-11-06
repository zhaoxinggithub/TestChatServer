package com.factory;

import com.abs.AbstractBase;
import com.vo.IChannelService;
import com.vo.IMessage;

public class Person extends AbstractBase implements IMessage, IChannelService {
    private int age;
    private String name;
    public Person(){}
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "姓名："+this.name+", age:"+this.age;
    }

    @Override
    public boolean connect() {
        return true;
    }

    @Override
    public void send() {
        if(this.connect()) {
            System.out.println("信息发送 www.mldn.cn");
        }
    }
}

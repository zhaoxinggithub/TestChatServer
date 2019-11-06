package com.dem5;

import java.io.*;

@SuppressWarnings("serial")
class PersonL implements Serializable{
    private transient String name;//在进行序列化处理时候name
    private int age;
    public PersonL(String name,int age){
        this.age=age;
        this.name=name;
    }

    @Override
    public String toString() {
        return "name:"+name+"--age:"+age;
    }
}
public class JavaTestSer {
    private static final File SAVE_FIEL=new File("./delete.Person");

    public static void main(String[] args) throws Exception{
//        saveObject(new PersonL("小人",22));
        System.out.println(loadObeject());


    }

    public static void saveObject(Object obj) throws Exception {
        ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(SAVE_FIEL));
        out.writeObject(obj);
        out.close();
    }

    public static Object loadObeject() throws Exception{
        ObjectInputStream in=new ObjectInputStream(new FileInputStream(SAVE_FIEL));
        Object obj=in.readObject();
        in.close();
        return obj;
    }


}

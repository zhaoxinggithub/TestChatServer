package com.demo27;

import java.util.*;

public class JavaAPIDemoList {
    public static void main(String[] args) {
//        methodArrayList();
//        methodLinkList();
//        methodVector();
        new JavaAPIDemoList().MethodHashSet();
    }

    public static void methodArrayList() {
        List list = new ArrayList<>();
        list.add("hello");
        list.add("hello");
        list.add("world");
        list.add("li");
        list.add(null);
        list.add(null);
//        list.remove("li");
        System.out.println(list.size());
        for (Object ob : list) {
            System.out.println(ob);
        }
    }

    public static void methodLinkList() {
        List list = new LinkedList();
        list.add("hello");
        list.add("hello");
        list.add("world");
        list.add("li");
        list.add(null);
        list.add(null);
//        list.remove("li");
        System.out.println(list.size());
        for (Object ob : list) {
            System.out.println(ob);
        }
    }

    public static void methodVector() {
        List list = new Vector();
        list.add("hello");
        list.add("hello");
        list.add("world");
        list.add("li");
        list.add(null);
        list.add(null);
//        list.remove("li");
        System.out.println(list.size());
        for (Object ob : list) {
            System.out.println(ob);
        }
    }

    public void MethodTreeSet() {
        Set<Person> set = new TreeSet<>();
        set.add(new Person("张一", 19));
        set.add(new Person("张二", 19));
        set.add(new Person("张三", 20));
        set.add(new Person("张三", 20));
        set.add(new Person("张四", 29));

        for (Object ob : set) {
            System.out.println(ob.toString());
        }
    }

    public void MethodHashSet() {
        Set<Personl> set = new HashSet<>();
        set.add(new Personl("张一", 19));
        set.add(new Personl("张二", 19));
        set.add(new Personl("张三", 20));
        set.add(new Personl("张三", 20));
        set.add(new Personl("张四", 29));
            for (Object ob : set) {
                System.out.println(ob.toString());
            }
    }
}
class Person implements Comparable{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Person oj=(Person) o;
        if(this.age>oj.getAge()){
            return 1;
        }else if(this.age<oj.getAge()){
            return -1;
        }else{
            return this.name.compareTo(oj.name);
        }
    }
}


class Personl {
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personl personl = (Personl) o;
        return age == personl.age &&
                Objects.equals(name, personl.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Personl(String name, int age) {
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    
    
    
    
    
    
    
    
}

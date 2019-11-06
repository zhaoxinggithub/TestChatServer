package com.dem5;

public class ComprableTest {
    public static void main(String[] args){
        Person p1=new Person("ZX",22);
        Person p2=new Person("li",26);
        System.out.println(p1.compareTo(p2));
    }

}
class Person implements Comparable{
    private String name;
    private int age;

    public Person(){};
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
        return this.age-((Person)o).getAge();
    }
}

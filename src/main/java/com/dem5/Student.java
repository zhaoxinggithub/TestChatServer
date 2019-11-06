package com.dem5;

public class Student implements Comparable<Student>{
    private String name;
    private double score;
    public Student(String name,double score){
        this.name=name;
        this.score=score;
    }
    public String toString(){
        return "姓名："+this.name+",分数："+this.score;
    }

    @Override
    public int compareTo(Student o) {
        if(this.score>o.score){
            return -1;
        }else if(this.score<o.score){
            return 1;
        }else{
            return 0;
        }
    }
}

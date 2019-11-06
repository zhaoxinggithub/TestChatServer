package com.imple;

import com.entity.Student;
import com.service.IVoteService;

import java.util.Arrays;

public class VoteServiceImple implements IVoteService {
    private Student[] students =new Student[]{new Student(1,"赵一",0),new Student(2,"赵二",0),new Student(3,"赵三",0),new Student(4,"赵四",0)};

//   private Student[] students= new Student[3](;
    @Override
    public boolean inc(long sid) {
        for(int i=0;i<this.students.length;i++){
            if(this.students[i].getSid() == sid){
                this.students[i].setVote(this.students[i].getVote()+1);//投票增长
                return true;
            }
        }
        return false;
    }

    @Override
    public Student[] result() {
                Arrays.sort(this.students);
                return this.students;
    }

    @Override
    public Student[] getData() {
        return this.students;
    }
}

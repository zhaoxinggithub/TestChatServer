package com.dem5;

import com.factory.StudentFactory;

import java.util.Arrays;

public class StudentDemo {
    public static void main(String []args){
        System.out.println(Arrays.toString(StudentFactory.getInstance().getData()));
    }
}

package com.dem5;

import com.factory.NumberFactory;

import java.util.Arrays;

public class IOCaseDemo3 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(NumberFactory.getInstance().stat()));
    }
}

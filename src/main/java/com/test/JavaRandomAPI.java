package com.test;

import java.util.Arrays;
import java.util.Random;

public class JavaRandomAPI {
    public static void main(String[] args){
        int [] data=new int[7];
        Random random=new Random();
        int foot=0;
        while(foot<7) {
        int num=random.nextInt(37);
            if (isHash(num, data)) {
                data[foot++] = num;
            }
        }
        Arrays.sort(data);
        for(int i=0;i<data.length;i++){

            System.out.print(data[i]+".");
        }
    }
    public static boolean isHash(int num,int [] data){
        if(num==0){
            return false;
        }
        for(int i=0;i<data.length;i++){
            if(num==data[i]){
                return false;
            }
        }
        return true;

    }
}

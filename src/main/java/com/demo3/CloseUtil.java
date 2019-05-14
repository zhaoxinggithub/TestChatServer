package com.demo3;

import java.io.Closeable;

public class CloseUtil {
    public CloseUtil(){

    }
    public static void closeAll(Closeable... io){
        Closeable[] closeables=io;
        int length=io.length;
        for(int i=0;i<length;i++){
            Closeable temp=closeables[i];
            while(null!=temp){
                try {
                    temp.close();
                }catch (Exception e){

                }
            }
        }
    }
}

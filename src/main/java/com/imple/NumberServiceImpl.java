package com.imple;

import com.service.INumberService;
import com.util.InputUtil;

public class NumberServiceImpl implements INumberService {
    @Override
    public int[] stat(int count) {
        int result[] =new int[2];
        int data[]=new int[count];
        for(int x=0;x<data.length;x++){
            data[x]= InputUtil.getInt("请输入第"+(x+1)+"数字：");
        }
        result[0]=data[0];
        result[1]=data[0];
        for(int i=0;i<count;i++){
            if(data[i]>result[0]){
                result[0]=data[i];
            }
            if(data[i]<result[1]){
                result[1]=data[i];
            }
        }
        return result;
    }
}

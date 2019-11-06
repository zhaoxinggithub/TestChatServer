package com.imple;

import com.service.INumberOldService;
import com.service.INumberService;
import com.util.InputUtil;

public class NumberOldServiceImple implements INumberOldService {

    @Override
    public int[] stat() {
        int stat[]=new int[]{0,0};//第一个为偶数，第二个为奇数
        String str= InputUtil.getString("请输入数字信息:");
        String result[]=str.split("");//依照每个字符拆分
        for(int x=0;x<result.length;x++){
            if(Integer.parseInt(result[x])%2==0){
                stat[0]++;
            }else{
                stat[1]++;
            }
        }
        return stat;
    }
}

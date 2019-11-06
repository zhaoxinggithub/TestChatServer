package com.imple;

import com.service.IStringService;

public class StringServiceImple implements IStringService {
    private StringBuffer data=new StringBuffer();


    @Override
    public void append(String str) {
        this.data.append(str).append("|");
    }

    @Override
    public String[] reverse() {
        String result[]=this.data.toString().split("\\|");
        int center=result.length/2;
        int head=0;
        int tail=result.length-1;
        for(int x=0;x<center;x++){
            String tmp=result[head];
            result[head]=result[tail];
            result[tail]=tmp;
            if(tail>=0&&head<center/2) {
                head++;
                tail--;
            }
        }
        return result;
    }
}

package com.dem5;

import com.factory.FactorIO;
import com.service.IFileService;

import java.io.File;

import static com.service.IFileService.SAVE_DIR;

public class IOCaseDemo2 {

    static {//项目启动时候该路径应该先创建
        File file = new File(SAVE_DIR);//路径，但是这个文件目录有可能不存在
        if (!file.exists()){
            file.mkdirs();//创建目录
        }
    }
    public static void main(String[] args){
        IFileService iFileServie= FactorIO.getInstance();
        System.out.println(iFileServie.save());
    }

}

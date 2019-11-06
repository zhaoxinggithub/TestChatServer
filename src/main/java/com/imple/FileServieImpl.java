package com.imple;

import com.service.IFileService;
import com.util.InputUtil;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileServieImpl implements IFileService {
    private String name;
    private String content;
    public FileServieImpl(){
        this.name= InputUtil.getString("请输入保存文件名称：");
        this.content= InputUtil.getString("请输入保存文件的内容");
    }
    @Override
    public boolean save() {
        File file=new File(IFileService.SAVE_DIR+this.name);
        PrintWriter out= null;
        boolean flag=false;
        try {

            out = new PrintWriter(new FileOutputStream(file));
            out.print(this.content);
            flag=true;
//            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            flag= false;
        }finally {
            if(out!=null){
                out.close();
            }
        }
        return true;


//        return true;
    }
}

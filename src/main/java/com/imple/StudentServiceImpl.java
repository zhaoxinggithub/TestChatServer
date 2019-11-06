package com.imple;

import com.dem5.Student;
import com.service.IStudentService;
import com.util.FileUtil;

import java.io.File;
import java.util.Arrays;

public class StudentServiceImpl implements IStudentService {
    private static final File SAVE_FILE = new File("./"+ File.separator+"mldndata"+File.separator+"student.txt");
    private String content;

    private Student[] students;
    public StudentServiceImpl(){
        this.content=FileUtil.load(SAVE_FILE);
        handle();
    }

    private void handle(){//进行数据处理
        if(null==content||"".equals(content)){
            return;
        }
        String result[]=this.content.split("\\|");//拆分数据
        this.students=new Student[result.length];
        for(int x=0;x<result.length;x++){
            String tmp[]=result[x].split(":");
            this.students[x]=new Student(tmp[0],Double.parseDouble(tmp[1]));
        }
    }

    @Override
    public void append(String str) {
        if(str.startsWith("|")){//最前面有"|"
            str=str.substring(1);//截取后面的部分
        }
        if(!str.endsWith("|")){//数据合理，可以直接追加
            str=str+"|";
        }
        FileUtil.append(SAVE_FILE,str);
    }

    @Override
    public Student[] getData() {
        Arrays.sort(this.students);
        return this.students;
    }
}

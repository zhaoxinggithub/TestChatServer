package com.dem5;

import java.io.*;

public class JavaAPIDemo {
    public static void main(String [] args) throws Exception{

       String source="";
       String des="";
        long start=System.currentTimeMillis();
        FileUtil fu=new FileUtil(args[0],args[1]);
        System.out.println(fu.copy()?"文件拷贝成功!":"文件拷贝失败！");
        long end=System.currentTimeMillis();
        System.out.println("拷贝完成的时间："+(end-start));
    }
}
class FileUtil{
    private File sourcefile;
    private File desfile;
    public FileUtil(String src,String des){
        this(new File(src),new File(des));
    }
    public FileUtil(File sourcefile,File desfile){
        this.sourcefile=sourcefile;
        this.desfile=desfile;
    }
    public boolean copy() throws Exception{
        if(!this.sourcefile.exists()){
            System.out.println("拷贝的源文件不存在！");
            return false;
        }
        return this.copyFileImpl(this.sourcefile,this.desfile);
    }

 private boolean copyFileImpl(File sourcefile, File desfile) {
        if(!this.sourcefile.exists()){
            //源文件必须存在
            System.out.println("拷贝的源文件不存在！");
            return false;//拷贝失败
        }
        if(!this.desfile.getParentFile().exists()){
            this.desfile.getParentFile().mkdirs();//创建父目录
        }
     InputStream input=null;
     OutputStream out=null;
      try{
          input=new FileInputStream(sourcefile);
          out=new FileOutputStream(desfile);
          int len=0;
          byte[] data=new byte[1024];
          while((len=input.read(data))!=-1){
              out.write(data,0,len);
          }
                  return true;
      }catch (Exception e){
          return false;
      }
    }
    public boolean copyDir() throws Exception{
        try{
            this.copyImpl(this.sourcefile);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private void copyImpl(File file) throws Exception{//递归操作
        if(file.isDirectory()){//是目录
            File results[]=file.listFiles();//列出全部目录
        if(results!=null){
            for(int x=0;x<results.length;x++){
                copyImpl(results[x]);
            }
        }
        }else{//是文件
                String newFilePath=file.getPath().replace(this.sourcefile.getPath()+File.separator,"");
                File newFile=new File(this.desfile,newFilePath);//拷贝的目标路径
                this.copyFileImpl(file,newFile);
        }

    }
}

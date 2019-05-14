package com.cc;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class InetaddressTest{
    public static void main(String[] args) throws MalformedURLException {
        URL url =new URL("http://www.baidu.com");
      try {
          /*
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
            BufferedWriter ws=new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"utf-8"));
            String ms=null;
            while((ms=bufferedReader.readLine())!=null){
                System.out.println(ms);
                ws.append(ms.trim());
                ws.newLine();

            }
            ws.flush();
            ws.close();
            bufferedReader.close();*/
            byte[] flush=new byte[1024];
            InputStream in=url.openStream();
            int len=0;
            while(-1!=(len=in.read(flush))){
                System.out.println(new String(flush,0,len));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

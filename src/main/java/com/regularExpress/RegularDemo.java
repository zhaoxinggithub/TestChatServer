package com.regularExpress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularDemo
{
    public static void main(String[] args){
//        System.out.println(allstr);
      /*  Pattern pattern=Pattern.compile("href=\"(.+?)\"");
        Matcher m=pattern.matcher(allstr);
        while(m.find()){
            System.out.println(m.group());
            System.out.println(m.group(1));
        }*/
        String des=getUlr("https://www.163.com","gbk");
//       List list= getMatch("href=\"(.+?)\"",des);
       List list= getMatch("href=\"([\\w\\s./:]+?)\"",des);
       System.out.println("-----------------------------");
       for(int i=0;i<list.size();i++){
           System.out.println(list.get(i));
       }
    }

    public static String getUlr(String link,String code){
        StringBuffer sb=new StringBuffer();
        try {
            URL url=new URL(link);
            BufferedReader reader=new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName(code)));
            String temp="";
            while((temp=reader.readLine())!=null){
                sb.append(temp);
                sb.append("\n\t");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<String> getMatch(String regex,String allstr){
        List<String> result=new ArrayList<String>();
        Pattern pattern=Pattern.compile(regex);
        Matcher m=pattern.matcher(allstr);
        while(m.find()){
            result.add(m.group(1));
        }
        return result;
    }


}

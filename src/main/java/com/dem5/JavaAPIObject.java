package com.dem5;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class JavaAPIObject {
    public static void main(String[] args) {
        String value="empno:3479|name:Smith|job:clerk|salary:750.00|hiredate:1989-08-10|"+"dept.dname:财务部|dept.company.name:MLDN";
        Emp emp=ClassInstanceFactory.create(Emp.class,value);
        System.out.println("编号："+emp.getEmpno()+",姓名："+emp.getName()+",职业："+emp.getJob()+",薪资："+emp.getSalary()+",入职时间："+emp.getHiredate());
        System.out.println(emp.getDept().getDname());
        System.out.println(emp.getDept().getCompany().getName());
    }
}
class ClassInstanceFactory{
    private ClassInstanceFactory(){}

    /**
     * 实例化对象的创建方法，该对象可以根据传入的字符串结构"属性：内容|属性：内容"
     *
     * @param clazz 要进行反射实例化的Class 类对象，有Class 就可以反射实例化对象
      * @param <T> 一个已经配置好属性内容的简单Java类对象
     * @return
     */
    public static<T> T create(Class<?> clazz,String value){
        //如果使用想采用反射进行简单Java类对象属性设置，类必须有无参构造
        try {
            Object obj=clazz.getDeclaredConstructor().newInstance();
            BeanUtil.setValue(obj,value);//通过反射设置属性
            return (T)obj;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
class StringUtil{
    public static String initcap(String str){
        if(str==null ||"".equals(str)){
            return str;
        }
        if(str.length()==1){
            return str.toUpperCase();
        }else{
            return str.substring(0,1).toUpperCase()+str.substring(1);
        }
    }
}
class BeanUtil{
    private BeanUtil(){}

    /**
     * 实现指定对象属性设置
     * @param obj
     * @param value
     */
    public static void setValue(Object obj,String value){
        String results[]=value.split("\\|");//按照"|" 进行每一组属性的拆分
        for(int x=0;x<results.length;x++){
            String attval[] =results[x].split(":");//获取属性名称与内容
            try {
                if(attval[0].contains(".")){//多级配置
                        String temp[]=attval[0].split("\\.");
//                    System.out.println(Arrays.toString(temp));
                        Object currentObject=obj;
                        //最后一位是指定类中的属性，所以不在本次实例化处理的范畴之内
                    for(int y=0;y<temp.length-1;y++){//实例化
                        System.out.println(temp[y]+"");
                        //调用相应的getter方法，如果getter方法返回例null表示该对象未实例化
                        Method getMethod=currentObject.getClass().getDeclaredMethod("get"+StringUtil.initcap(temp[y]));
                        Object tempObject=getMethod.invoke(currentObject);
                        if(tempObject == null){
                            Field field=currentObject.getClass().getDeclaredField(temp[y]);//获取属性
                            Method method=currentObject.getClass().getDeclaredMethod("set"+StringUtil.initcap(temp[y]),field.getType());
                            Object newObject=field.getType().getConstructor().newInstance();
                            method.invoke(currentObject,newObject);
                            currentObject=newObject;
                        }else{
                            currentObject=tempObject;
                        }
                    }
                    //进行属性内容的设置
                    Field field=currentObject.getClass().getDeclaredField(temp[temp.length-1]);//获取成员

                    Method setMethod=currentObject.getClass().getDeclaredMethod("set"+StringUtil.initcap(temp[temp.length-1]),field.getType());
                    Object convertValue=BeanUtil.convertAttributeValue(field.getType().getName(),attval[1]);
                    setMethod.invoke(currentObject,convertValue);//调用setter 方法设置内容

                }else {
                    Field field = obj.getClass().getDeclaredField(attval[0]);//获取成员
                    Method setMethod = obj.getClass().getDeclaredMethod("set" + StringUtil.initcap(attval[0]), field.getType());
                    System.out.println(field.getType().getName());
                    Object val = BeanUtil.convertAttributeValue(field.getType().getName(), attval[1]);
//                setMethod.invoke(obj,attval[1]);  //调用setter 方法设置内容
                    setMethod.invoke(obj, val);
                }
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
    }

    /**
     * 实现类型转换设置
     * @param type
     * @param value
     * @return
     */
    private static Object convertAttributeValue(String type,String value){
        if("long".equals(type)||"java.lang.long".equals(type)){
            return Long.parseLong(value);
        }else if("int".equals(type)||"java.lang.int".equals(type)){
            return Integer.parseInt(value);
        }else if("double".equals(type)||"java.lang.double".equals(type)){
            return Double.parseDouble(value);
        }else if("java.util.Date".equals(type)){
            SimpleDateFormat sdf=null;
            if(value.matches("\\d{4}-\\d{2}-\\d{2}")){
                sdf=new SimpleDateFormat("yyyy-MM-dd");
            }else if(value.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
                sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }else{
                return new Date();//当前日期
            }
            try {
                return sdf.parse(value);
            } catch (ParseException e) {
                return new Date();//当前日期
            }
        }else{
            return value;
        }
    }
}
class Dept{
    private String dname;
    private String loc;
    private Company company;

    public Company getCompany() {
        System.out.println("get company");
        return company;
    }

    public void setCompany(Company company) {
        System.out.println("set company");
        this.company = company;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
    public Dept(){

    }
}
class Company{
    private String name;
    private Date createdate;

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("set company name");
        this.name = name;
    }

    public Company(){}
}

class Emp{
    private long empno;
    private String name;
    private String job;
    private double salary;
    private Date hiredate;
    private Dept dept;
    public Emp(){
    }
    public Dept getDept() {
        System.out.println("get dept");
        return dept;
    }

    public void setDept(Dept dept) {
        System.out.println("set dept");
        this.dept = dept;
    }

    public long getEmpno() {
        return empno;
    }

    public void setEmpno(long empno) {
        this.empno = empno;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}


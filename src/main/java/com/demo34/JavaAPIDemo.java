package com.demo34;

import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaAPIDemo {
    public static void main(String[] args) {
       /* List<String> all=new ArrayList<>();
        Collections.addAll(all,"JAVA","JavaScript","Python","Ruby","Go");
        Stream<String> stream =all.stream();//可以获得Stream接口对象
//        System.out.println(stream.filter((ele)->ele.toLowerCase().contains("j")).count());
        ArrayList list= (ArrayList) stream.filter((ele)->ele.toLowerCase().contains("j")).collect(Collectors.toList());
        System.out.println(list.toString());*/

       //如果要想使用Stream进行分析处理，则一定要将全部要分析的数据保存在集合之中
        List<Order> all=new ArrayList<Order>();
        all.add(new Order("小强娃娃",9.9,10));
        all.add(new Order("林弱充气娃娃",2987.9,3));
        all.add(new Order("不强牌笔记本电脑",8987.9,8));
        all.add(new Order("弱强茶杯",2.9,800));
        all.add(new Order("阿强牌煎饼",0.9,138));
        //分析购买商品之中带有"强"的信息数据,并且进行商品单价和数量的处理，然后分析汇总
        DoubleSummaryStatistics stat=all.stream().filter((ele)->ele.getName().contains("强"))
                .mapToDouble((orderObject)->orderObject.getPrice()*orderObject.getAmount()).summaryStatistics();
        System.out.println("购买数量："+stat.getCount());
        System.out.println("购买总价:"+stat.getSum());
        System.out.println("平均花费:"+stat.getAverage());
        System.out.println("最高花费:"+stat.getMax());

    }
}
class Order{
    private String name;//商品名称
    private double price;//商品价格
    private int amount;//商品数量
    public Order(String name,double price,int amount){
        this.name=name;
        this.price=price;
        this.amount=amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

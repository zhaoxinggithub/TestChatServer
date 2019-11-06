package com.menu;

import com.entity.Student;
import com.factory.IVoteFactory;
import com.service.IVoteService;
import com.util.InputUtil;

public class VoteMenu {
    private IVoteService iVoteService;
    public VoteMenu(){
        this.iVoteService=IVoteFactory.getInstance();
        this.vote();
    }

    private void vote() {
        Student[] stu= this.iVoteService.getData();
        for(Student tmp:stu){
            System.out.println(tmp.getSid()+":"+tmp.getName()+":"+tmp.getVote());
        }
        int num=2;
        while(0!=num){
            num=InputUtil.getInt("请输入数字进行投票 0代表结束");
            if(num!=0) {
                if(!this.iVoteService.inc(num)){
                    System.out.println("投票无效，请输入正确的代号！");
                }
            }
        }
        stu=this.iVoteService.result();
        System.out.println("同学："+stu[0]+"票数为："+stu[0].getVote()+" 成功当选班长");
    }


}

package com.service;

import com.entity.Student;

public interface IVoteService {
    public boolean inc(long sid);//根据编号进行增长
    public Student[] result();//获取投票结果
    public Student[] getData();
}

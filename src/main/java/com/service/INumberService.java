package com.service;

public interface INumberService {
    /**
     * 输入最大最小
     * @param count 代表输入数字个数
     * @return 代表输出结果 第一个最大值 第二个最小值
     */
    public int[] stat(int count);
}

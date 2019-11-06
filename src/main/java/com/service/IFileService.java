package com.service;

import java.io.File;

public interface IFileService {
     static final String SAVE_DIR="./"+ File.separator+"mldndata"+File.separator;
    /**
     * 定义文件的保存处理方法
     * @return 保存成功返回true 保存失败返回false
     */
    public boolean save();
}

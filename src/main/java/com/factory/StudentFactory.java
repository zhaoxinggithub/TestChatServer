package com.factory;

import com.imple.StudentServiceImpl;
import com.service.IStudentService;
import com.util.InputUtil;

public class StudentFactory {
    private StudentFactory(){}
    public static IStudentService getInstance(){
        return new StudentServiceImpl();
    }
}

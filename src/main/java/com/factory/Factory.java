package com.factory;

import com.imple.NumberServiceImpl;
import com.service.INumberOldService;
import com.service.INumberService;

public class Factory {
    private Factory(){}
    public static INumberService getInstance(){
        return new NumberServiceImpl();
    }
}

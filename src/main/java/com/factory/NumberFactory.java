package com.factory;

import com.imple.NumberOldServiceImple;
import com.service.INumberOldService;

public class NumberFactory {
    private NumberFactory(){}
    public static INumberOldService getInstance(){
        return new NumberOldServiceImple();
    }
}

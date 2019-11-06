package com.factory;

import com.imple.FileServieImpl;
import com.service.IFileService;

public class FactorIO {
    private FactorIO(){}
    public static IFileService getInstance(){
        return new FileServieImpl();
    }
}

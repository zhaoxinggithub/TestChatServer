package com.factory;

import com.imple.StringServiceImple;
import com.service.IFileService;
import com.service.IStringService;

public class AppendFactory {
    private AppendFactory(){}
    public static IStringService getInstance(){
        return new StringServiceImple();
    }
}

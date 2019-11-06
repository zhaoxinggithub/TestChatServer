package com.factory;

import com.imple.VoteServiceImple;
import com.service.IVoteService;

public class IVoteFactory {
    private void IVoteFactory(){}
    public static IVoteService getInstance(){
        return new VoteServiceImple();
    }
}

package com.peanuts.community.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.peanuts.community.data.entity.common.User;
import com.peanuts.community.data.repository.RdbRepository;
import com.peanuts.community.data.repository.rdb.UserRepository;
import com.peanuts.community.service.AbstractService;

public class UserServiceImpl extends AbstractService<User,Long>{

    @Autowired
    UserRepository userRepository;
    
    @Override
    protected RdbRepository<User, Long> repository() {
        return userRepository;
    }
}

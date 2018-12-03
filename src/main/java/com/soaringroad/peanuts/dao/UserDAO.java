package com.soaringroad.peanuts.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soaringroad.dao.impl.BasicManageDAOImpl;
import com.soaringroad.peanuts.entity.User;
import com.soaringroad.peanuts.repository.UserRepository;

/**
 * <pre>
 * User Service
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/07
 */
@Component
public class UserDAO extends BasicManageDAOImpl<User, Long> {

    @Autowired
    private UserRepository userRepo;

    public User getByNameAndPassword(String name, String password) {
        return this.userRepo.getByNameAndPassword(name, password);
    }
}

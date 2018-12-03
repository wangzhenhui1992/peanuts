package com.soaringroad.peanuts.service;

import com.soaringroad.peanuts.entity.User;

/**
 * <pre>
 * Security Service
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/12/03
 */
public interface SecurityService {

    /**
     * Authentication
     * 
     * @param name     user name
     * @param password password
     * @return JWT
     */
    String authenticate(String name, String password);

    /**
     * Generate a JWT
     * 
     * @param userId   user ID
     * @param userName user name
     * @return JWT
     */
    String authorize(long userId, String userName);

    /**
     * Check if {@code token} is right
     * 
     * @param token
     * @return User information
     */
    User checkAuthorization(String token);
}

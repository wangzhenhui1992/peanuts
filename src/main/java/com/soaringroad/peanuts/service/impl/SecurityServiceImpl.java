package com.soaringroad.peanuts.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.soaringroad.common.util.CommonUtils;
import com.soaringroad.peanuts.dao.UserDAO;
import com.soaringroad.peanuts.entity.JwtToken;
import com.soaringroad.peanuts.entity.User;
import com.soaringroad.peanuts.repository.JwtTokenRepository;
import com.soaringroad.peanuts.service.SecurityService;
import com.soaringroad.peanuts.vo.SecurityInfo;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * Implementation of {@link SecurityService}
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/12/03
 */
@Component
@Slf4j
public class SecurityServiceImpl implements SecurityService {

    /**
     * DAO of {@link User}
     */
    @Autowired
    private UserDAO userDAO;

    /**
     * Security Information Started with {@code peanuts.security} in SpringBoot
     * properties
     */
    @Autowired
    private SecurityInfo securityInfo;

    /**
     * Repository for JWT
     */
    @Autowired(required = false)
    private JwtTokenRepository jwtTokenRepository;

    /**
     * @see com.soaringroad.peanuts.service.SecurityService#authenticate(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public String authenticate(String name, String password) {
        User user = userDAO.getByNameAndPassword(name, password);
        if (user == null) {
            return null;
        }
        String token = authorize(user.getId(), name);
        if (jwtTokenRepository != null) {
            JwtToken jwtToken = new JwtToken();
            jwtToken.setToken(token);
            jwtToken.setUser(user);
            jwtTokenRepository.setValue(token, jwtToken);
            jwtTokenRepository.expire(token, securityInfo.getLoginTimeout() / 1000);
        }
        return token;
    }

    /**
     * @see com.soaringroad.peanuts.service.SecurityService#authorize(long,
     *      java.lang.String)
     */
    @Override
    public String authorize(long userId, String userName) {
        Algorithm hmac256 = Algorithm.HMAC256(securityInfo.getSecurityKey());
        String token = JWT.create().withIssuer("login").withClaim("userid", userId).withClaim("username", userName)
                .withClaim("time", System.currentTimeMillis()).sign(hmac256);
        return token;
    }

    /**
     * @see com.soaringroad.peanuts.service.SecurityService#checkAuthorization(java.lang.String)
     */
    @Override
    public User checkAuthorization(String token) {
        if (jwtTokenRepository != null) {
            return Optional.ofNullable(jwtTokenRepository.getValue(token)).map(JwtToken::getUser).orElse(null);
        }
        Algorithm hmac256 = Algorithm.HMAC256(securityInfo.getSecurityKey());
        JWTVerifier verifier = JWT.require(hmac256).withIssuer("login").build();
        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
        } catch (JWTVerificationException e) {
            log.warn("Illegal jwt : " + token);
            return null;
        }
        Long userId = jwt.getClaim("userid").asLong();
        String userName = jwt.getClaim("username").asString();
        Long time = jwt.getClaim("time").asLong();
        User user = getMatchedUser(userId, userName);
        if (user == null || isTokenTimeout(time)) {
            return null;
        }
        return user;
    }

    /**
     * Get user with specific id {@code userId} and name {@code userName}
     * 
     * @param userId
     * @param userName
     * @return
     */
    private User getMatchedUser(Long userId, String userName) {
        if (CommonUtils.isStringEmpty(userName) || userId == null) {
            return null;
        }
        User user = userDAO.get(userId);
        return user != null && user.getName().equals(userName) ? user : null;
    }

    /**
     * Check if token is timeout
     * 
     * @param time when token generated
     * @return true or false
     */
    private boolean isTokenTimeout(Long time) {
        return time == null || System.currentTimeMillis() - time > securityInfo.getLoginTimeout();
    }

}

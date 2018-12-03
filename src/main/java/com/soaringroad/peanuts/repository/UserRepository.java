package com.soaringroad.peanuts.repository;

import org.springframework.stereotype.Repository;

import com.soaringroad.common.repository.RdbRepository;
import com.soaringroad.peanuts.entity.User;

/**
 * <pre>
 * Repository of {@link com.soaringroad.peanuts.entity.User}
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/06
 */
@Repository
public interface UserRepository extends RdbRepository<User, Long> {
    /**
     * Check user name and password
     * @param name user name
     * @param password password
     * @return 
     */
    User getByNameAndPassword(String name,String password);
}

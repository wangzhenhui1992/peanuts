package com.soaringroad.peanuts.service.aggregation;

import org.springframework.stereotype.Component;

import com.soaringroad.dao.aggregation.DefaultAggregation;
import com.soaringroad.peanuts.entity.User;

/**
 * <pre>
 * Aggregation for user
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Component
public class UserAggregation extends DefaultAggregation<User, Long> {
}
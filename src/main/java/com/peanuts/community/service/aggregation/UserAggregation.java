package com.peanuts.community.service.aggregation;

import org.springframework.stereotype.Component;

import com.peanuts.community.data.entity.common.User;

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
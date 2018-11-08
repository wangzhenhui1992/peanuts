package com.peanuts.community.service.strategy;

import org.springframework.stereotype.Component;

import com.peanuts.community.data.entity.common.User;

@Component
public class UserAggregation extends DefaultAggregation<User, Long> {
}
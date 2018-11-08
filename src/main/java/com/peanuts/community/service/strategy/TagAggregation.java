package com.peanuts.community.service.strategy;

import org.springframework.stereotype.Component;

import com.peanuts.community.data.entity.common.Tag;

@Component
public class TagAggregation extends DefaultAggregation<Tag, Long> {
}

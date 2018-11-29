package com.soaringroad.peanuts.service.aggregation;

import org.springframework.stereotype.Component;

import com.soaringroad.dao.aggregation.DefaultAggregation;
import com.soaringroad.peanuts.entity.Tag;

/**
 * <pre>
 * Aggregation for tag
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Component
public class TagAggregation extends DefaultAggregation<Tag, Long> {
}

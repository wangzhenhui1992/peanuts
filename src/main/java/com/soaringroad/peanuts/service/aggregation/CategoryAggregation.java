package com.soaringroad.peanuts.service.aggregation;

import org.springframework.stereotype.Component;

import com.soaringroad.dao.aggregation.DefaultAggregation;
import com.soaringroad.peanuts.entity.Category;

/**
 * <pre>
 * Aggregation for category
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Component
public class CategoryAggregation extends DefaultAggregation<Category,Long> {
    
}

package com.soaringroad.peanuts.service.aggregation;

import org.springframework.stereotype.Component;

import com.soaringroad.common.dao.Aggregation;
import com.soaringroad.peanuts.entity.Comment;

/**
 * <pre>
 * Aggregation for comment
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Component
public class CommentAggregation implements Aggregation<Comment, Long> {
    
    @Override
    public Comment aggregate(Comment entity) {
//        entity.setUser(userService.get(entity.getUserId()));
        return entity;
    }

}

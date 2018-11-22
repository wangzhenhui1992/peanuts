package com.peanuts.community.service.aggregation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.peanuts.community.data.entity.common.Comment;
import com.peanuts.community.data.entity.common.User;
import com.peanuts.community.service.AbstractBrowseService;

/**
 * <pre>
 * Aggregation for comment
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Component
public class CommentAggregation implements Aggregation<Comment, Long> {

    @Autowired
    private AbstractBrowseService<User,Long> userService;
    
    @Override
    public Comment aggregate(Comment entity) {
        entity.setUser(userService.get(entity.getUserId()));
        return entity;
    }

}

package com.peanuts.community.service.aggregation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.peanuts.community.common.util.CommonUtils;
import com.peanuts.community.data.entity.common.Article;
import com.peanuts.community.data.entity.common.Category;
import com.peanuts.community.data.entity.common.Comment;
import com.peanuts.community.data.entity.common.Tag;
import com.peanuts.community.data.entity.common.User;
import com.peanuts.community.service.BasicBrowseServiceImpl;

/**
 * <pre>
 * Aggregation for article
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Component
public class ArticleAggregation implements Aggregation<Article, Long> {

    @Autowired
    private BasicBrowseServiceImpl<Tag, Long> tagService;

    @Autowired
    private BasicBrowseServiceImpl<User, Long> userService;

    @Autowired
    private BasicBrowseServiceImpl<Comment, Long> commentService;

    @Autowired
    private BasicBrowseServiceImpl<Category, Long> categoryService;

    @Override
    public Article aggregate(Article entity) {
        List<Long> categoryIds = entity.getCategoryIds();
        if (!CommonUtils.isCollectionEmpty(categoryIds)) {
            entity.setCategories(categoryService.findAllById(categoryIds));
        }
        List<Long> tagIds = entity.getTagIds();
        if (!CommonUtils.isCollectionEmpty(categoryIds)) {
            entity.setTags(tagService.findAllById(tagIds));
        }
        List<Long> commentIds = entity.getCommentIds();
        if (!CommonUtils.isCollectionEmpty(commentIds)) {
            entity.setComments(commentService.findAllById(commentIds));
        }
        entity.setUser(userService.get(entity.getUserId()));
        return entity;
    }

}

package com.soaringroad.peanuts.service.aggregation;

import org.springframework.stereotype.Component;

import com.soaringroad.common.dao.Aggregation;
import com.soaringroad.peanuts.entity.Article;

/**
 * <pre>
 * Aggregation for article
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Component
public class ArticleAggregation implements Aggregation<Article, Long> {

    @Override
    public Article aggregate(Article entity) {
        return entity;
    }

}

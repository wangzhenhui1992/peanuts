package com.peanuts.community.data.repository.redis;

import org.springframework.stereotype.Component;

import com.peanuts.community.data.entity.common.Article;
/**
 * <pre>
 * Redis Repository for article
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/21
 */
public class ArticleRedisRepository extends AbstractRedisRepository<Article, Long> {

    @Override
    protected String entityName() {
        return Article.ENTITY_NAME;
    }
}

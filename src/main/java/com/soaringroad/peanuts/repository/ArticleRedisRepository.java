package com.soaringroad.peanuts.repository;

import com.soaringroad.data.redis.AbstractRedisRepository;
import com.soaringroad.peanuts.entity.Article;
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

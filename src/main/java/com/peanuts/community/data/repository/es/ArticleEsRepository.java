package com.peanuts.community.data.repository.es;

import com.peanuts.community.data.entity.common.Article;
/**
 * <pre>
 * Add Some Description Please
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/21
 */
public class ArticleEsRepository extends AbstractEsRepository<Article, Long> {

    @Override
    protected ElasticsearchIndexDefine define() {
        ElasticsearchIndexDefine articleDefine = new ElasticsearchIndexDefine();
        articleDefine.setIndexName(Article.ENTITY_NAME);
        return articleDefine;
    }

}

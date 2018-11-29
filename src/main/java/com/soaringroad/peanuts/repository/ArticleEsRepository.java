package com.soaringroad.peanuts.repository;

import com.soaringroad.data.es.AbstractEsRepository;
import com.soaringroad.data.es.ElasticsearchIndexDefine;
import com.soaringroad.peanuts.entity.Article;
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

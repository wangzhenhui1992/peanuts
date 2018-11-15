package com.peanuts.community.data.repository.es;

import org.springframework.stereotype.Repository;

import com.peanuts.community.data.entity.common.Article;
import com.peanuts.community.data.repository.ElasticSearchRepository;

@Repository
public interface ArticleEsRepository extends ElasticSearchRepository<Article,Long> {

}

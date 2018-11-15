package com.peanuts.community.data.repository.rdb;

import org.springframework.stereotype.Repository;

import com.peanuts.community.data.entity.common.Article;
import com.peanuts.community.data.repository.RdbRepository;

/**
 * <pre>
 * Repository of {@link com.peanuts.community.data.entity.common.Article}
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/06
 */
@Repository
public interface ArticleRepository extends RdbRepository<Article, Long> {

}

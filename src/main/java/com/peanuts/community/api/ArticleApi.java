package com.peanuts.community.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peanuts.community.data.entity.common.Article;

/**
 * <pre>
 * Article API class
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/27
 */
@RequestMapping("/api/"+Article.ENTITY_NAME)
@RestController
public class ArticleApi extends BasicManageApi<Article,Long>{

}

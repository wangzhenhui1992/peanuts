package com.peanuts.community.common.util;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import com.peanuts.community.data.query.QueryCondition;
import com.peanuts.community.data.query.QueryOptionEnum;
/**
 * <pre>
 * Utility class of Elasticsearch
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public class ElasticsearchUtil {
    private ElasticsearchUtil() {
    }

    public static void buildEsQueryConditions(QueryCondition[] queryConditions, BoolQueryBuilder queryBuilder) {
        if (queryConditions == null || queryConditions.length == 0) {
            queryBuilder.must(QueryBuilders.matchAllQuery());
            return;
        }
        for (QueryCondition queryCondition : queryConditions) {
            String name = queryCondition.getName();
            Object value = queryCondition.getValue();
            QueryOptionEnum queryOption = queryCondition.getOption();
            switch (queryOption) {
            case EQ:
                queryBuilder.must(QueryBuilders.matchPhraseQuery(name, value));
                break;
            case GEQ:
                queryBuilder.must(QueryBuilders.rangeQuery(name).from(value));
                break;
            case LEQ:
                queryBuilder.must(QueryBuilders.rangeQuery(name).to(value));
                break;
            case MEMBER:
                queryBuilder.must(QueryBuilders.matchPhraseQuery(name, value));
            default:
                break;
            }
        }
    }
}

package com.peanuts.community.data.query;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

import com.peanuts.community.common.util.CommonUtils;
import com.peanuts.community.common.util.ElasticsearchUtil;

/**
 * <pre>
 * ES(Rest)用QueryBuilder
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/20
 */
public class EsRestQueryBuilder implements QueryBuilder {
    private Query queryEntity;

    public EsRestQueryBuilder(@NotNull Query queryEntity) {
        this.queryEntity = queryEntity;
    }

    @Override
    @SuppressWarnings("unchecked")
    public SearchSourceBuilder build() {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        buildConditions(boolQueryBuilder);
        buildSort(sourceBuilder);
        buildPage(sourceBuilder);
        sourceBuilder.query(boolQueryBuilder);
        if (!CommonUtils.isArrayEmpty(this.queryEntity.fetchFields)) {
            sourceBuilder.fetchSource(this.queryEntity.fetchFields, null);
        }
        return sourceBuilder;
    }

    private void buildConditions(BoolQueryBuilder boolQueryBuilder) {
        QueryCondition[] queryConditions = this.queryEntity.getQueryConditions();
        ElasticsearchUtil.buildEsQueryConditions(queryConditions, boolQueryBuilder);
    }

    private void buildSort(SearchSourceBuilder sourceBuilder) {
        QuerySort[] querySorts = this.queryEntity.getQuerySort();
        if (querySorts != null && querySorts.length > 0) {
            for (QuerySort sort : querySorts) {
                sourceBuilder.sort(sort.getName(),
                        QuerySortOrderEnum.ASC.equals(sort.getSortOrder()) ? SortOrder.ASC : SortOrder.DESC);
            }
        }
    }

    private void buildPage(SearchSourceBuilder sourceBuilder) {
        int pageNumber = Optional.ofNullable(this.queryEntity.getPageNumber()).orElse(0);
        int queryNumber =  Optional.ofNullable(this.queryEntity.getQueryNumber()).orElse(10);
        sourceBuilder.from(pageNumber * queryNumber);
        sourceBuilder.size(queryNumber);
    }

}

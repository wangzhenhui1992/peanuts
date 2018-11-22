//package com.peanuts.community.data.query;
//
//import javax.validation.constraints.NotNull;
//
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.sort.FieldSortBuilder;
//import org.elasticsearch.search.sort.SortOrder;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.data.elasticsearch.core.query.SearchQuery;
//
//import com.peanuts.community.common.util.CommonUtils;
//import com.peanuts.community.common.util.ElasticsearchUtil;
//
//public class EsQueryBuilder implements QueryBuilder {
//
//    private QueryEntity queryEntity;
//
//    public static EsQueryBuilder of(@NotNull QueryEntity queryEntity) {
//        return new EsQueryBuilder(queryEntity);
//    }
//
//    private EsQueryBuilder(QueryEntity queryEntity) {
//        this.queryEntity = queryEntity;
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public SearchQuery build() {
//        QueryCondition[] queryConditions = queryEntity.getQueryConditions();
//        QuerySort[] querySorts = queryEntity.getQuerySort();
//        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
//        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
//        ElasticsearchUtil.buildEsQueryConditions(queryConditions, queryBuilder);
//        nativeSearchQueryBuilder.withQuery(queryBuilder);
//        buildEsSorts(querySorts, nativeSearchQueryBuilder);
//        if (!CommonUtils.isArrayEmpty(queryEntity.fetchFields)) {
//            nativeSearchQueryBuilder.withFields();
//        }
//        return nativeSearchQueryBuilder.build();
//    }
//
//    private static void buildEsSorts(QuerySort[] querySorts, NativeSearchQueryBuilder nativeSearchQueryBuilder) {
//        if (querySorts == null || querySorts.length == 0) {
//            return;
//        }
//        for (QuerySort querySort : querySorts) {
//            String name = querySort.getName();
//            QuerySortOrderEnum sortOrder = querySort.getSortOrder();
//            nativeSearchQueryBuilder.withSort(new FieldSortBuilder(name)
//                    .order(QuerySortOrderEnum.ASC.equals(sortOrder) ? SortOrder.ASC : SortOrder.DESC));
//        }
//    }
//
//}

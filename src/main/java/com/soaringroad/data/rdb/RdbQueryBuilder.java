package com.soaringroad.data.rdb;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.soaringroad.common.query.Query;
import com.soaringroad.common.query.QueryBuilder;
import com.soaringroad.common.query.QueryCondition;
import com.soaringroad.common.query.QuerySort;
import com.soaringroad.common.vo.QuerySortOrderEnum;

/**
 * <pre>
 * QueryBuilder of rdb
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public class RdbQueryBuilder<T> implements QueryBuilder {

    private Query queryEntity;

    public RdbQueryBuilder(@NotNull Query queryEntity) {
        this.queryEntity = queryEntity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public RdbQuery<T> build() {
        Pageable pageable = buildPage(queryEntity);
        Specification<T> spec = buildSpec();
        return new RdbQuery<T>(pageable, spec);
    }

    private Pageable buildPage(Query queryEntity) {
        QuerySort[] querySorts = queryEntity.getQuerySort();
        Integer queryNum = queryEntity.getQueryNumber();
        Integer pageNum = queryEntity.getPageNumber();
        PageRequest pageRequest = PageRequest.of(pageNum == null || pageNum < 0 ? 0 : pageNum,
                queryNum == null || queryNum <= 0 ? 20 : queryNum, buildSort(querySorts));
        return pageRequest;
    }

    private Specification<T> buildSpec() {
        final QueryCondition[] queryConditions = queryEntity.getQueryConditions();
        Specification<T> spec = new QuerySpecifier<T>(queryConditions, queryEntity.getFetchFields());
        return spec;
    }

    private Sort buildSort(QuerySort[] querySorts) {
        if (querySorts == null || querySorts.length == 0) {
            return Sort.unsorted();
        }
        Sort sort = null;
        for (QuerySort querySort : querySorts) {
            String name = querySort.getName();
            QuerySortOrderEnum sortOrder = querySort.getSortOrder();
            Sort tempSort = new Sort(
                    QuerySortOrderEnum.ASC.equals(sortOrder) ? Sort.Direction.ASC : Sort.Direction.DESC, name);
            if (sort == null) {
                sort = tempSort;
                continue;
            }
            sort.and(tempSort);
        }
        return sort == null ? Sort.unsorted() : sort;
    }
}

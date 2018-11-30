package com.soaringroad.data.rdb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import org.springframework.data.jpa.domain.Specification;

import com.soaringroad.common.query.QueryCondition;
import com.soaringroad.common.util.CommonUtils;

/**
 * <pre>
 * QuerySpecifier
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public class QuerySpecifier<T> implements Specification<T> {

    private static final long serialVersionUID = 1L;

    private QueryCondition[] queryConditions;

    private String[] fetchFields;

    public QuerySpecifier(QueryCondition[] queryConditions, String[] fetchFields) {
        this.queryConditions = queryConditions;
        this.fetchFields = fetchFields;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (queryConditions == null || queryConditions.length == 0) {
            return null;
        }
        criteriaBuilder.createQuery();
        List<Predicate> predicateList = buildPredicateList(root,query,criteriaBuilder);
        Predicate[] predicates = new Predicate[predicateList.size()];
        query = query.where(predicateList.toArray(predicates));
        if (!CommonUtils.isArrayEmpty(fetchFields)) {
            // TODO fetch fields
        }
        return query.getRestriction();

    }

    private List<Predicate> buildPredicateList(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicateList = new ArrayList<>();
        for (QueryCondition queryCondition : queryConditions) {
            Object value = queryCondition.getValue();
            switch (queryCondition.getOption()) {
            case EQ:
                Path<Object> pathEq = root.get(queryCondition.getName());
                predicateList.add(criteriaBuilder.equal(pathEq, value));
                break;
            case GEQ:
                Path<Long> pathGe = root.get(queryCondition.getName());
                predicateList.add(criteriaBuilder.ge(pathGe, Long.valueOf(value.toString())));
                break;
            case LEQ:
                Path<Long> pathLe = root.get(queryCondition.getName());
                predicateList.add(criteriaBuilder.ge(pathLe, Long.valueOf(value.toString())));
                break;
            case MEMBER:
                Path<Collection<String>> pathIn = root.<Collection<String>>get(queryCondition.getName());
                predicateList.add(criteriaBuilder.isMember(String.valueOf(value), pathIn));
                break;
            default:
                break;
            }
        }
        return predicateList;
    }

}

package com.peanuts.community.data.repository.rdb;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.peanuts.community.data.query.Query;
import com.peanuts.community.data.query.RdbQuery;
import com.peanuts.community.data.query.RdbQueryBuilder;
/**
 * <pre>
 * SearchableSimpleJpaRepository
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public class SearchableSimpleJpaRepository<T, E> extends SimpleJpaRepository<T, E> implements RdbSearchable<T> {

    public SearchableSimpleJpaRepository(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
    }

    @Override
    public List<T> search(Query queryEntity) {
        RdbQuery<T> rdbQuery = new RdbQueryBuilder<T>(queryEntity).build();
        return Optional.ofNullable(this.findAll(rdbQuery.getSpecification(), rdbQuery.getPageRequest()))
                .map(Page<T>::getContent).orElse(null);
    }
}

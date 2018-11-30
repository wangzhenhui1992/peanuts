package com.soaringroad.data.rdb;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.soaringroad.common.query.Query;
import com.soaringroad.data.Searchable;
/**
 * <pre>
 * SearchableSimpleJpaRepository
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public class SearchableSimpleJpaRepository<T, E> extends SimpleJpaRepository<T, E> implements Searchable<T> {

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

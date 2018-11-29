package com.soaringroad.data.rdb;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

/**
 * <pre>
 * Factory to produce JpaRepository with search function
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public class SearchableJpaRepositoryFactory extends JpaRepositoryFactory {

    public SearchableJpaRepositoryFactory(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
        return SearchableSimpleJpaRepository.class;
    }

    @Override
    protected JpaRepositoryImplementation<?, ?> getTargetRepository(RepositoryInformation information,
            EntityManager entityManager) {
        return generalNewInstance(information.getDomainType(), entityManager, information.getIdType());
    }

    private <D, E> SearchableSimpleJpaRepository<D, E> generalNewInstance(Class<D> domainType,
            EntityManager entityManager, Class<E> idType) {
        return new SearchableSimpleJpaRepository<D, E>(domainType, entityManager);
    }

}

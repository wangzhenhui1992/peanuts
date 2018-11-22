//package com.peanuts.community.data.repository.rdb;
//
//import java.io.Serializable;
//
//import javax.persistence.EntityManager;
//
//import com.peanuts.community.data.entity.RdbEntity;
//import com.peanuts.community.data.repository.RdbRepository;
//
//public class BaseRdbRepository<T extends RdbEntity, E extends Serializable> extends SearchableSimpleJpaRepository<T, E>
//        implements RdbRepository<T, E> {
//
//    public BaseRdbRepository(Class<T> domainClass, EntityManager em) {
//        super(domainClass, em);
//    }
//}

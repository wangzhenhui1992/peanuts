package com.soaringroad.data.rdb;

import javax.validation.constraints.NotNull;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import lombok.Data;

/**
 * <pre>
 * Query of rdb
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Data
public class RdbQuery<T> {
    private Pageable pageRequest;

    private Specification<T> specification;

    public RdbQuery(@NotNull Pageable pageRequest, @NotNull Specification<T> specification) {
        this.pageRequest = pageRequest;
        this.specification = specification;
    }

}

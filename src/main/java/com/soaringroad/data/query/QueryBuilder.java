package com.soaringroad.data.query;

/**
 * <pre>
 * Interface of QueryBuilder
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
public interface QueryBuilder {
    <T> T build();
}

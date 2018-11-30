package com.soaringroad.data;

import java.util.List;

import com.soaringroad.common.query.Query;

/**
 * <pre>
 * Searchable
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/30
 */
public interface Searchable<T> {

    List<T> search(Query entity);
}

package com.soaringroad.common.query;

import lombok.Data;

/**
 * <pre>
 * Query
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Data
public class Query {
    private QueryCondition[] queryConditions;
    private QuerySort[] querySort;
    private Integer queryNumber;
    private Integer pageNumber;
    private String[] fetchFields;
}

package com.soaringroad.common.query;

import com.soaringroad.common.vo.QueryOptionEnum;

import lombok.Data;

/**
 * <pre>
 * Query condition
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Data
public class QueryCondition {
    private String name;
    private QueryOptionEnum option;
    private String value;
}

package com.soaringroad.common.query;

import com.soaringroad.common.vo.QueryOptionEnum;

import lombok.Data;

/**
 * <pre>
 * Filter of Query
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Data
public class QueryFilter {

	private String fieldName;
	private QueryOptionEnum option;
	private String value;
}

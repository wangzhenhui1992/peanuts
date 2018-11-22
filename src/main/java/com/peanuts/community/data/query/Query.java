package com.peanuts.community.data.query;

import lombok.Data;

/**
 * <pre>
 * Query
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Data
public class Query {
	QueryCondition[] queryConditions;
	QuerySort[] querySort;
	Integer queryNumber;
	Integer pageNumber;
	String[] fetchFields;
}

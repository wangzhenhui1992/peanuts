package com.peanuts.community.data.query;

import lombok.Data;

/**
 * <pre>
 * Sort of Query 
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/22
 */
@Data
public class QuerySort {
	private String name;
	private QuerySortOrderEnum sortOrder;
}

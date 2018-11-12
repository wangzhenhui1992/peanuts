package com.peanuts.community.common;

import com.peanuts.community.common.vo.BrowseControlLevelEnum;
import com.peanuts.community.data.entity.common.User;

/**
 * <pre>
 * Holds the context for each request
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/09
 */
public class RequestContext {
    public static final ThreadLocal<BrowseControlLevelEnum> BROWSE_CONTROL_LEVEL = new  ThreadLocal<BrowseControlLevelEnum>();
    public static final ThreadLocal<User> LOGIN_USER = new ThreadLocal<User>();
}

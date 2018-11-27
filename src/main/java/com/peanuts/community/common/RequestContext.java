package com.peanuts.community.common;

import com.peanuts.community.common.vo.BrowseControlLevelEnum;
import com.peanuts.community.data.entity.common.User;

/**
 * <pre>
 * Holds the context for each request
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/09
 */
public class RequestContext {
    private static final ThreadLocal<BrowseControlLevelEnum> BROWSE_CONTROL_LEVEL = new ThreadLocal<BrowseControlLevelEnum>();
    private static final ThreadLocal<User> LOGIN_USER = new ThreadLocal<User>();

    static {
        setBrowseControlLevel(BrowseControlLevelEnum.ADMIN);
    }
    public static final void setBrowseControlLevel(BrowseControlLevelEnum level) {
        BROWSE_CONTROL_LEVEL.set(level);
    }
    
    public static final BrowseControlLevelEnum getBrowseControlLevel() {
        return BROWSE_CONTROL_LEVEL.get();
    }
    
    public static final void removeBrowseControlLevel() {
        BROWSE_CONTROL_LEVEL.remove();
    }

    public static final void setLoginUser(User user) {
        LOGIN_USER.set(user);
    }
    
    public static final User getLoginUser() {
        return LOGIN_USER.get();
    }
    
    public static final void removeLoginUser() {
        LOGIN_USER.remove();
    }
    
    public static final void removeAll() {
        BROWSE_CONTROL_LEVEL.remove();
        LOGIN_USER.remove();
    }
   

}

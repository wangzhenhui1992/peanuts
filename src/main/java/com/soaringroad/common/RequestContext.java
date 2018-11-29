package com.soaringroad.common;

import com.soaringroad.common.vo.BrowseControlLevelEnum;
import com.soaringroad.peanuts.entity.User;

/**
 * <pre>
 * Holds the context for each request
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/09
 */
public class RequestContext {
    private static final ThreadLocal<String> SUBJECT = new ThreadLocal<String>();
    private static final ThreadLocal<BrowseControlLevelEnum> BROWSE_CONTROL_LEVEL = new ThreadLocal<BrowseControlLevelEnum>();
    private static final ThreadLocal<User> LOGIN_USER = new ThreadLocal<User>();

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

    public static final void setSubject(String subject) {
        SUBJECT.set(subject);
    }

    public static final String getSubject() {
        return SUBJECT.get();
    }

    public static final void removeSubject() {
        SUBJECT.remove();
    }

    public static final void removeAll() {
        BROWSE_CONTROL_LEVEL.remove();
        LOGIN_USER.remove();
        SUBJECT.remove();
    }

}

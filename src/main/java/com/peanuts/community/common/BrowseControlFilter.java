package com.peanuts.community.common;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.peanuts.community.common.vo.BrowseControlLevelEnum;

/**
 * <pre>
 * To filter the field with annotation {@link BrowseContolColumn} level under {@link RequestContext#BROWSE_CONTROL_LEVEL}
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/12
 */
public class BrowseControlFilter extends SimpleBeanPropertyFilter{

    @Override
    protected boolean include(BeanPropertyWriter writer) {
        return isBrowseTarget(writer);
    }

    @Override
    protected boolean include(PropertyWriter writer) {
        return isBrowseTarget(writer);
    }
    
    private boolean isBrowseTarget(PropertyWriter writer) {
        BrowseControlColumn browseControlColumn = writer.getAnnotation(BrowseControlColumn.class);
        BrowseControlLevelEnum level = browseControlColumn == null ? BrowseControlLevelEnum.LIST
                : browseControlColumn.level();
        return RequestContext.BROWSE_CONTROL_LEVEL.get().compareTo(level) >= 0;
    }

}

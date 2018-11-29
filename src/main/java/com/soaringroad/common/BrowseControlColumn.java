package com.soaringroad.common;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import com.soaringroad.common.vo.BrowseControlLevelEnum;

/**
 * <pre>
 * Field with {@code @BrowseControlColumn} will not be json-serialized in BrowseMode
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
@Documented
@Target({FIELD,METHOD})
@JacksonAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface BrowseControlColumn {
    BrowseControlLevelEnum level() default BrowseControlLevelEnum.MODIFY;
}

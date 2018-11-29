package com.soaringroad.common.util;

import java.io.IOException;
import java.util.Collection;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * <pre>
 * Common Utilities
 * If this class is large enough, we should divide it into more classes.
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/08
 */
@Component
@Slf4j
public class CommonUtils {

    @Autowired
    private static ObjectMapper objectMapper;

    private CommonUtils() {
    };

    /**
     * <pre>
     * Return true when {@code c} is null or has no elements.Otherwise return false.
     * </pre>
     * 
     * @param c collection
     * @return true or false
     */
    public static final boolean isCollectionEmpty(Collection<?> c) {
        return c == null || c.isEmpty();
    }

    /**
     * <pre>
     * Return true when {@code str} is null or empty.Otherwise return false.
     * </pre>
     * 
     * @param str string
     * @return true or false
     */
    public static final boolean isStringEmpty(String str) {
        return str == null || str.isEmpty();
    }

    /**
     * <pre>
     * Return true when {@code str} is null or its length is 0 after {@link String#trim()}.Otherwise return false.
     * </pre>
     * 
     * @param str string
     * @return true or false
     */
    public static final boolean isStringEmptyWithTrim(String str) {
        return isStringEmpty(str) || str.trim().isEmpty();

    }

    /**
     * <pre>
     * Return true only when array is null or its length is 0. Otherwise return false.
     * </pre>
     * 
     * @param array
     * @return
     */
    public static final <T extends Object> boolean isArrayEmpty(T[] array) {
        return array == null || array.length == 0;
    }

    /**
     * <pre>
     * Parse target to JSON string
     * Return null if {@code obj} is null or it can not be parsed
     * </pre>
     * @param obj target
     * @return JSON string
     */
    public static String parseToJsonString(Object obj) {
        if (obj == null) {
            return null;
        }
        String jsonStr = null;
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("can not parse object to json. obj="+obj,e);
        }
        return jsonStr;
    }
    /**
     * <pre>
     * Parse JSON string to target
     * Return null if {@code jsonStr} is null or it can not be parsed and {@code clazz} can not be null
     * </pre>
     * @param jsonStr JSON string
     * @return object
     */
    public static <T> T parseToObject(String jsonStr, @NotNull Class<T> clazz) {
        if (jsonStr == null) {
            return null;
        }
        T obj = null;
        try {
            obj = objectMapper.readValue(jsonStr, clazz);
        } catch (IOException e) {
            log.error("can not parse json to object. json="+jsonStr,e);
        }
        return obj;
    }
}

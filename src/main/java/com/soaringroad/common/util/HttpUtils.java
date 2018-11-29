package com.soaringroad.common.util;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * <pre>
 * Utility class of HTTP
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/27
 */
public class HttpUtils {

    private HttpUtils() {
    }

    /**
     * Parse entity to ResponseEntity for get method
     * 
     * @param entity
     * @return
     */
    public static <T> ResponseEntity<T> parseToGetResponse(T entity) {
        return ResponseEntity.of(Optional.ofNullable(entity));
    }

    /**
     * Parse entity to ResponseEntity for post method
     * 
     * @param entity
     * @return
     */
    public static <T> ResponseEntity<T> parseToPostResponse(T entity) {
        return Optional.ofNullable(entity).map(ResponseEntity.created(null)::body)
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }

    /**
     * Parse entity to ResponseEntity for put method
     * 
     * @param entity
     * @return
     */
    public static <T> ResponseEntity<T> parseToPutResponse(T entity) {
        return ResponseEntity.of(Optional.ofNullable(entity));
    }

    /**
     * Parse entity to ResponseEntity for delete method
     * 
     * @param entity
     * @return
     */
    public static <T> ResponseEntity<T> parseToDeleteResponse(T entity) {
        return Optional.ofNullable(entity).map(t -> new ResponseEntity<T>(HttpStatus.NOT_FOUND))
                .orElse(ResponseEntity.ok().build());
    }

    /**
     * Parse entity to ResponseEntity for search
     * 
     * @param entity
     * @return
     */
    public static <T> ResponseEntity<List<T>> parseToSearchResponse(List<T> entity) {
        return Optional.ofNullable(entity).map(ResponseEntity::ok).orElse(ResponseEntity.noContent().build());
    }

    /**
     * Not found
     * @return
     */
    public static <T> ResponseEntity<T> notFound() {
        return ResponseEntity.notFound().build();
    }
    
    /**
     * Method Not Allowed
     * @return
     */
    public static <T> ResponseEntity<T> methodNotAllowed() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }
    
    /**
     * Method Not Allowed
     * @return
     */
    public static <T> ResponseEntity<T> badRequest() {
        return ResponseEntity.badRequest().build();
    }
}

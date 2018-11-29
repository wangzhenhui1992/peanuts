package com.soaringroad.common;
//package com.peanuts.community.common;
//
//import java.io.IOException;
//import java.util.Objects;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
///**
// * <pre>
// * Customized EntityMapper with customized ObjectMapper possible for Elasticsearch
// * </pre>
// * 
// * @author wangzhenhui1992
// * @since 2018/11/15
// */
//public class EntityMapper implements org.springframework.data.elasticsearch.core.EntityMapper {
//
//    private ObjectMapper objectMapper;
//
//    private EntityMapper(ObjectMapper objectMapper) {
//        this.objectMapper = objectMapper;
//    };
//
//    public static final EntityMapper of(ObjectMapper objectMapper) {
//        return new EntityMapper(Objects.requireNonNull(objectMapper, "objectMapper must not be null"));
//    }
//
//    public static final EntityMapper ofDefault() {
//        return of(new ObjectMapper());
//    }
//
//    @Override
//    public String mapToString(Object object) throws IOException {
//        return this.objectMapper.writeValueAsString(object);
//    }
//
//    @Override
//    public <T> T mapToObject(String source, Class<T> clazz) throws IOException {
//        return this.objectMapper.readValue(source, clazz);
//    }
//}

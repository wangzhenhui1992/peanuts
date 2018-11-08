package com.peanuts.community.data.entity.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.peanuts.community.data.entity.CommonEntity;

import lombok.Data;

/**
 * <pre>
 * Category
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/05
 */
@Data
@Entity(name = "comment")
@Table(name = "peanuts_comment")
public class Comment implements CommonEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 4651965101132492079L;
    private static final String ENTITY_NAME = "category";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;
    
    @Column(nullable = false)
    @JsonIgnore
    private Long userId;
    
    @Transient
    private User user;
    
    @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @Override
    public String entityName() {
        return ENTITY_NAME;
    }
}

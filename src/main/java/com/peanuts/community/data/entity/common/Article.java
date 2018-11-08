package com.peanuts.community.data.entity.common;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
 * Article
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
@Data
@Entity(name = "article")
@Table(name = "peanuts_article")
public class Article implements CommonEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 83339089943794630L;

    private static final String ENTITY_NAME = "article";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String summary;

    @Column(length = 10000)
    private String content;

    @JsonIgnore
    private Long userId;

    @Transient
    private User user;

    @JsonIgnore
    @ElementCollection(targetClass = Long.class)
    private List<Long> categoryIds;

    @Transient
    private List<Category> categories;

    @JsonIgnore
    @ElementCollection(targetClass = Long.class)
    private List<Long> tagIds;

    @Transient
    private List<Tag> tags;

    @JsonIgnore
    @ElementCollection(targetClass = Long.class)
    private List<Long> commentIds;

    @Transient
    private List<Comment> comments;

    @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @DateTimeFormat(iso = ISO.DATE)
    private Date updateDate;

    @Override
    public String entityName() {
        return ENTITY_NAME;
    }
}

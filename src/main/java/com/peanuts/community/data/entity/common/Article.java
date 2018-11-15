package com.peanuts.community.data.entity.common;

import java.util.ArrayList;
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

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.peanuts.community.common.BrowseControlColumn;
import com.peanuts.community.common.vo.BrowseControlLevelEnum;
import com.peanuts.community.data.entity.CommonEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * Article
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/02
 */
@Data
@Entity(name = Article.ENTITY_NAME)
@Document(indexName = Article.ENTITY_NAME)
public class Article implements CommonEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 83339089943794630L;

    public static final String ENTITY_NAME = "article";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String summary;

    @BrowseControlColumn(level=BrowseControlLevelEnum.VIEW)
    @Column(length = 10000, nullable = false)
    private String content;

    @Column(nullable = false)
    @JsonIgnore
    private Long userId;

    @Transient
    private User user;

    @JsonIgnore
    @ElementCollection(targetClass = Long.class)
    private List<Long> categoryIds = new ArrayList<Long>();

    @Transient
    private List<Category> categories;

    @JsonIgnore
    @ElementCollection(targetClass = Long.class)
    private List<Long> tagIds = new ArrayList<Long>();

    @Transient
    private List<Tag> tags;

    @JsonIgnore
    @ElementCollection(targetClass = Long.class)
    private List<Long> commentIds = new ArrayList<Long>();

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

    @BrowseControlColumn(level=BrowseControlLevelEnum.VIEW)
    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
}

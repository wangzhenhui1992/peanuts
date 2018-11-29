package com.soaringroad.peanuts.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soaringroad.common.BrowseControlColumn;
import com.soaringroad.common.entity.CommonEntity;
import com.soaringroad.common.vo.BrowseControlLevelEnum;

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
@Entity(name = Article.ENTITY_NAME)
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

    @BrowseControlColumn(level = BrowseControlLevelEnum.VIEW)
    @Column(length = 10000, nullable = false)
    private String content;

    @Column(nullable = false)
    @JsonIgnore
    private Long userId;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Category> categories;

    @ManyToMany
    private List<Tag> tags;

    @ManyToMany
    private List<Comment> comments;

    @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateDate;

    @Override
    public String entityName() {
        return ENTITY_NAME;
    }

    @BrowseControlColumn(level = BrowseControlLevelEnum.VIEW)
    public List<Comment> getComments() {
        return comments;
    }
    
    /**
     * @see com.soaringroad.common.entity.Entity#getId()
     */
    @SuppressWarnings("unchecked")
    @Override
    public Long getId() {
        return this.id;
    }
}

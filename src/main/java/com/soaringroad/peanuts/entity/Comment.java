package com.soaringroad.peanuts.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soaringroad.common.BrowseControlColumn;
import com.soaringroad.common.entity.CommonEntity;
import com.soaringroad.common.vo.BrowseControlLevelEnum;

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
@Entity(name = Comment.ENTITY_NAME)
public class Comment implements CommonEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 4651965101132492079L;
    public static final String ENTITY_NAME = "comment";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @BrowseControlColumn(level=BrowseControlLevelEnum.VIEW)
    private String content;
    
    @ManyToOne
    @BrowseControlColumn(level=BrowseControlLevelEnum.VIEW)
    private User user;
    
    @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @Override
    public String entityName() {
        return ENTITY_NAME;
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

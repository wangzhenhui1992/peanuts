package com.peanuts.community.data.entity.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.peanuts.community.common.BrowseControlColumn;
import com.peanuts.community.common.vo.BrowseControlLevelEnum;
import com.peanuts.community.data.entity.CommonEntity;

import lombok.Data;

/**
 * <pre>
 * User
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/05
 */
@Data
@Entity(name = User.ENTITY_NAME)
public class User implements CommonEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 2615852091906261918L;
    public static final String ENTITY_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    @BrowseControlColumn(level = BrowseControlLevelEnum.VIEW)
    private String mail;
    
    @BrowseControlColumn(level = BrowseControlLevelEnum.VIEW)
    private String tel;

    @Column()
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @Override
    public String entityName() {
        return ENTITY_NAME;
    }
    
    /**
     * @see com.peanuts.community.data.entity.Entity#getId()
     */
    @SuppressWarnings("unchecked")
    @Override
    public Long getId() {
        return this.id;
    }
}

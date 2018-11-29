package com.soaringroad.peanuts.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.soaringroad.common.BrowseControlColumn;
import com.soaringroad.common.entity.CommonEntity;
import com.soaringroad.common.vo.BrowseControlLevelEnum;
import com.soaringroad.common.vo.RoleEnum;

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

    @BrowseControlColumn(level = BrowseControlLevelEnum.SECRET)
    private String password;

    @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;
    
    @BrowseControlColumn(level = BrowseControlLevelEnum.SECRET)
    private RoleEnum role;

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

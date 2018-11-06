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
@Entity(name = "user")
@Table(name = "peanuts_user")
public class User implements CommonEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 2615852091906261918L;
    private static final String ENTITY_NAME = "user";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    private String mail;
    
    private String tel;
    
    @Column()
    private String password;
    
    @DateTimeFormat(iso = ISO.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    @Override
    public String entityName() {
        return ENTITY_NAME;
    }
}

package com.peanuts.community.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.peanuts.community.data.entity.common.Tag;
import com.peanuts.community.data.repository.RdbRepository;
import com.peanuts.community.data.repository.rdb.TagRepository;
import com.peanuts.community.service.AbstractService;

public class TagServiceImpl extends AbstractService<Tag,Long>{

    @Autowired
    TagRepository tagRepository;

    @Override
    protected RdbRepository<Tag, Long> repository() {
        return tagRepository;
    }

}

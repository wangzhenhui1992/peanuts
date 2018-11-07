package com.peanuts.community.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.peanuts.community.data.entity.common.Comment;
import com.peanuts.community.data.repository.RdbRepository;
import com.peanuts.community.data.repository.rdb.CommentRepository;
import com.peanuts.community.service.AbstractService;

public class CommentServiceImpl extends AbstractService<Comment,Long>{
    
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment doGet(Long id) {
        return null;
    }

    @Override
    protected List<Comment> doFindAllById(List<Long> ids) {
        commentRepository.findAllById(ids);
        return null;
    }

    @Override
    protected RdbRepository<Comment, Long> repository() {
        return commentRepository;
    }

}

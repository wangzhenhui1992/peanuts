package com.peanuts.community.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.peanuts.community.data.entity.common.Category;
import com.peanuts.community.data.repository.RdbRepository;
import com.peanuts.community.data.repository.rdb.CategoryRepository;
import com.peanuts.community.service.AbstractService;

public class CategoryServiceImpl extends AbstractService<Category, Long> {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category doGet(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category doUpdate(Category entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Category doCreate(Category entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void doDelete(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    protected List<Category> doFindAllById(List<Long> ids) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected RdbRepository<Category, Long> repository() {
        return categoryRepository;
    }

}

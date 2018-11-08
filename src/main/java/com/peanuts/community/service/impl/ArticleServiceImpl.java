package com.peanuts.community.service.impl;

import java.util.List;

import com.peanuts.community.data.entity.common.Article;
import com.peanuts.community.data.repository.RdbRepository;
import com.peanuts.community.data.repository.rdb.ArticleRepository;
import com.peanuts.community.service.AbstractService;

public class ArticleServiceImpl extends AbstractService<Article, Long> {

    private ArticleRepository articleRepository;

    @Override
    public Article doGet(Long id) {
        Article article = articleRepository.getOne(id);
        return article;
    }

    @Override
    public Article doUpdate(Article entity) {
        Article article = articleRepository.save(entity);
        return article;
    }

    @Override
    public Article doCreate(Article entity) {
        Article article = articleRepository.save(entity);
        return article;
    }

    @Override
    public void doDelete(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    protected List<Article> doFindAllById(List<Long> ids) {
        List<Article> articles = articleRepository.findAllById(ids);
        return articles;
    }

    @Override
    protected RdbRepository<Article, Long> repository() {
        return articleRepository;
    }

}

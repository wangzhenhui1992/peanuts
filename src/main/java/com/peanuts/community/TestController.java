package com.peanuts.community;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.peanuts.community.common.RequestContext;
import com.peanuts.community.common.vo.BrowseControlLevelEnum;
import com.peanuts.community.data.entity.common.Article;
import com.peanuts.community.data.entity.common.Category;
import com.peanuts.community.data.entity.common.Comment;
import com.peanuts.community.data.entity.common.Tag;
import com.peanuts.community.data.entity.common.User;
import com.peanuts.community.service.BasicManageServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {
    @Autowired
    private BasicManageServiceImpl<Article,Long> articleService;
    
    @Autowired
    private BasicManageServiceImpl<Tag,Long> tagService;
    
    @Autowired
    private BasicManageServiceImpl<Category,Long> categoryService;
    @Autowired
    private BasicManageServiceImpl<Comment,Long> commentService;
    
    @Autowired
    private BasicManageServiceImpl<User,Long> userService;
    
//    @Autowired
//    private ElasticSearchRepository<Article,Long> articleRepository;

    @RequestMapping(value = "/insert", method= {RequestMethod.GET} , produces = MediaType.APPLICATION_JSON_VALUE)
    public Article category() throws JsonProcessingException {
        RequestContext.setBrowseControlLevel(BrowseControlLevelEnum.ADMIN);
        User user = new User();
        user.setName("wzh");
        user.setMail("605951224@qq.com");
        user.setPassword("wzh");
        user.setTel("1234567890");
        log.info("user="+userService.create(user));
        
        Tag tag = new Tag();
        tag.setName("tag1");
        tag.setCreateDate(new Date());
        log.info("tag="+tagService.create(tag));
        
        Category category = new Category();
        category.setName("category1");
        category.setCreateDate(new Date());
        log.info("category="+categoryService.create(category));
        
        Comment comment = new Comment();
        comment.setContent("Comment1");
        comment.setUserId(Long.valueOf(1));
        log.info("comments="+commentService.create(comment));
        
        Article article = new Article();
        article.getCommentIds().add(Long.valueOf(1));
        article.getCategoryIds().add(Long.valueOf(1));
        article.getTagIds().add(Long.valueOf(1));
        article.setTitle("title1");
        article.setSummary("summary1");
        article.setContent("content1");
        article.setUserId(Long.valueOf(1));
        Article newArticle = articleService.create(article);
        log.info("article="+newArticle);
//        articleRepository.index(newArticle);
        return newArticle;
    }
    
    @RequestMapping("/article")
    public String article() {
        return articleService.get(Long.valueOf(1)).toString();
    }
}

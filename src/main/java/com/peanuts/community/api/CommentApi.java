package com.peanuts.community.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peanuts.community.data.entity.common.Comment;

/**
 * <pre>
 * Comment API class
 * </pre>
 * 
 * @author wangzhenhui1992
 * @since 2018/11/27
 */
@RequestMapping("/api/" + Comment.ENTITY_NAME)
@RestController
public class CommentApi extends BasicManageApi<Comment, Long> {

}

package com.peanuts.community.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peanuts.community.data.entity.common.Tag;

/**
 * <pre>
 * Tag API class
 * </pre>
 * @author wangzhenhui1992
 * @since 2018/11/27
 */
@RequestMapping("/api/"+Tag.ENTITY_NAME)
@RestController
public class TagApi extends BasicManageApi<Tag,Long>{

}

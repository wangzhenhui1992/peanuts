package com.soaringroad.peanuts.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soaringroad.api.BasicManageApi;
import com.soaringroad.peanuts.entity.Tag;

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

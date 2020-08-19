package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Austin
 * @date 2019/8/25
 */
public interface CmsTemplateRepository extends MongoRepository<CmsTemplate, String > {
}

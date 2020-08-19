package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsSite;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Austin
 * @date 2019/8/28
 */
public interface CmsSiteRepository extends MongoRepository<CmsSite, String> {
}

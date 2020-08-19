package com.xuecheng.manage_course.dao;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Austin
 * @date 2019/8/26
 */
@Mapper
public interface CategoryMapper {
    //查询分类
    public CategoryNode selectList();
}

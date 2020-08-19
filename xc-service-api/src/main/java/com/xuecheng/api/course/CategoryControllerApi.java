package com.xuecheng.api.course;

import com.xuecheng.framework.domain.course.ext.CategoryNode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Austin
 * @date 2019/8/26
 */
@Api(value="课程分类管理",description = "课程分类管理",tags = {"课程分类管理"})
public interface CategoryControllerApi {
    @ApiOperation("查询分类")
    public CategoryNode findList();
}

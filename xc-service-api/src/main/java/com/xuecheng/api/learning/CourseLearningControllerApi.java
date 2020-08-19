package com.xuecheng.api.learning;

import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.domain.learning.respones.GetMediaResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Administrator.
 */
@Api(value = "录播课程学习管理",description = "录播课程学习管理")
public interface CourseLearningControllerApi {

    @ApiOperation("获取课程学习地址")
    public GetMediaResult getmedia(String courseId, String teachplanId);

    @ApiOperation("获取课程信息")
    public QueryResponseResult findCourseList(int page, int size, CourseListRequest courseListRequest);
}

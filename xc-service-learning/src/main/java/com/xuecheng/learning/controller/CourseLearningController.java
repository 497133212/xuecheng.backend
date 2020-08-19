package com.xuecheng.learning.controller;

import com.xuecheng.api.learning.CourseLearningControllerApi;
import com.xuecheng.framework.domain.course.ext.CourseInfo;
import com.xuecheng.framework.domain.course.request.CourseListRequest;
import com.xuecheng.framework.domain.learning.respones.GetMediaResult;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.learning.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @version 1.0
 **/
@RestController
@RequestMapping("/learning/course")
public class CourseLearningController implements CourseLearningControllerApi {

    @Autowired
    LearningService learningService;

    @Override
    @GetMapping("/getmedia/{courseId}/{teachplanId}")
    public GetMediaResult getmedia(@PathVariable("courseId") String courseId,
                                   @PathVariable("teachplanId")String teachplanId) {

        return learningService.getmedia(courseId,teachplanId);
    }

    @Override
    @PostMapping("/choosecourse/list/{page}/{size}")
    public QueryResponseResult findCourseList(@PathVariable("page") int page, @PathVariable("size") int size, CourseListRequest courseListRequest) {
        //获取当前用户信息
//        XcOauth2Util xcOauth2Util = new XcOauth2Util();
//        XcOauth2Util.UserJwt userJwt = xcOauth2Util.getUserJwtFromHeader(request);
//        //当前用户所属单位的id
//        String company_id = userJwt.getCompanyId();
        String company_id = "1";
        QueryResponseResult<CourseInfo> queryResponseResult = learningService.findCourseList(company_id,page,size,courseListRequest);
        return queryResponseResult;
    }

}

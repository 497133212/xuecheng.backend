package com.xuecheng.framework.domain.cms.response;

import com.xuecheng.framework.domain.cms.CmsSite;
import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;

import java.util.List;

/**
 * @author Austin
 * @date 2019/10/12
 */
public class CmsSiteResult extends ResponseResult {
    List<CmsSite> cmsSiteList;
    public CmsSiteResult(ResultCode resultCode, List<CmsSite> cmsSiteList) {
        super(resultCode);
        this.cmsSiteList = cmsSiteList;
    }
}

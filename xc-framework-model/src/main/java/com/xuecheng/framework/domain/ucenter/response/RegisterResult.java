package com.xuecheng.framework.domain.ucenter.response;

import com.xuecheng.framework.model.response.ResponseResult;
import com.xuecheng.framework.model.response.ResultCode;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Austin
 * @date 2019/10/10
 */
@Data
@ToString
@NoArgsConstructor
public class RegisterResult extends ResponseResult{
    public RegisterResult(ResultCode resultCode) {
        super(resultCode);
    }
}

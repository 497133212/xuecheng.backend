package com.xuecheng.framework.domain.ucenter.request;

import com.xuecheng.framework.model.request.RequestData;
import lombok.Data;
import lombok.ToString;

/**
 * @author Austin
 * @date 2019/10/10
 */
@Data
@ToString
public class RegisterRequest extends RequestData {
    String username;
    String password;
    String confirmPassword;
    String name;
    String utype;
    String sex;
    String email;
    String phone;
    String qq;
}


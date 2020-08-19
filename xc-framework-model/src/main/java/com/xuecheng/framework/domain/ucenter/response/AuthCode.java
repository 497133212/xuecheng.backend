package com.xuecheng.framework.domain.ucenter.response;

import com.google.common.collect.ImmutableMap;
import com.xuecheng.framework.model.response.ResultCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.ToString;


/**
 * Created by admin on 2018/3/5.
 */
@ToString
public enum AuthCode implements ResultCode {
    AUTH_USERNAME_NONE(false,23001,"请输入账号！"),
    AUTH_PASSWORD_NONE(false,23002,"请输入密码！"),
    AUTH_CONFIRMPASSWORD_NONE(false,23003,"请输入确认密码！"),
    AUTH_PASSWORDANDCONFIRMPASSWORD_ERROR(false,23004,"两次输入的密码不相同！"),
    AUTH_VERIFYCODE_NONE(false,23005,"请输入验证码！"),
    AUTH_ACCOUNT_NOTEXISTS(false,23006,"账号不存在！"),
    AUTH_CREDENTIAL_ERROR(false,23007,"账号或密码错误！"),
    AUTH_LOGIN_ERROR(false,23008,"登陆过程出现异常请尝试重新操作！"),
    AUTH_LOGIN_APPLYTOKEN_FAIL(false,23009,"申请令牌失败！"),
    AUTH_LOGIN_TOKEN_SAVEFAIL(false,23010,"存储令牌失败！"),
    AUTH_REGISTER_EXISTS(false,23011,"此账号已经存在!"),
    AUTH_SUCCESS(true,23012,"注册成功");

    //操作代码
    @ApiModelProperty(value = "操作是否成功", example = "true", required = true)
    boolean success;

    //操作代码
    @ApiModelProperty(value = "操作代码", example = "22001", required = true)
    int code;
    //提示信息
    @ApiModelProperty(value = "操作提示", example = "操作过于频繁！", required = true)
    String message;
    private AuthCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }
    private static final ImmutableMap<Integer, AuthCode> CACHE;

    static {
        final ImmutableMap.Builder<Integer, AuthCode> builder = ImmutableMap.builder();
        for (AuthCode commonCode : values()) {
            builder.put(commonCode.code(), commonCode);
        }
        CACHE = builder.build();
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}

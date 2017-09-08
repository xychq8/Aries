package cn.com.bianlz.user.common;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
public enum UserProtocolCode {
    SUCCESS("U10000","成功!"),
    LOGIN_USER_NOT_FOUND("U10001","用户不存在!"),
    LOGIN_PASSWORD_ERROR("U10002","密码错误!");
    private String code;
    private String message;
    UserProtocolCode(String code,String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

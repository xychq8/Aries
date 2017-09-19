package cn.com.bianlz.web.common;

/**
 * Created by bianlanzhou on 17/9/13.
 * Description
 */
public enum WebApiProtocolCode {
    SUCCESS("W10000","操作成功!"),
    AUTH_FAIL("W10001","你没有权限操作!"),
    REDIRECT("W10002","跳转!"),
    FAIL("W10003","操作失败!");
    private String code;
    private String message;
    WebApiProtocolCode(String code,String message){
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

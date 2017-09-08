package cn.com.bianlz.common.enums;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
public enum Status {
    INVALID(0),VALID(1);
    private int code;
    Status(int code){
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}

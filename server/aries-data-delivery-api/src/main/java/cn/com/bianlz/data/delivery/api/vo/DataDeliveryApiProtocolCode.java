package cn.com.bianlz.data.delivery.api.vo;

/**
 * Created by bianlanzhou on 17/10/31.
 * Description
 */
public enum DataDeliveryApiProtocolCode {
    SUCCESS("DD10000","操作成功"),
    FAIL("DD10003","操作失败");
    private String code;
    private String message;
    DataDeliveryApiProtocolCode(String code,String message){
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

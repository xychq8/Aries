package cn.com.bianlz.data.delivery.common;

/**
 * Created by bianlanzhou on 17/11/1.
 * Description
 */
public class PositionEnums {
    public enum channel implements MybatisStringTypeHandlerEnum{
        NEWS("7A16FBB6","网易新闻客户端"),
        MAIL_MASTER("3E0F733C","邮箱大师"),
        UNKNOW("-10","未知");
        private String code;
        private String name;
        channel(String code,String name){
            this.code = code;
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
        @Override
        public String getString() {
            return name;
        }
    }
}

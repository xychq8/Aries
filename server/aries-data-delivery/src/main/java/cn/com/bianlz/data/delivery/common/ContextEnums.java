package cn.com.bianlz.data.delivery.common;

/**
 * Created by bianlanzhou on 17/11/1.
 * Description
 */
public class ContextEnums {
    public enum Sex{
        MALE(1,"男"),FEMALE(2,"女"),UNLIMITED(-1,"不限"),UNKNOW(-10,"未知");
        private Integer code;
        private String name;
        Sex(Integer code,String name){
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Integer getCode() {
            return code;
        }
    }
    public enum Os{
        ANDRIOD(1,"andriod"),IOS(2,"ios"),UNLIMITED(-1,"不限"),UNKNOW(-10,"未知");
        private Integer code;
        private String name;
        Os(Integer code,String name){
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Integer getCode() {
            return code;
        }
    }
    public enum Network{
        WIFI(1,"wifi"),_2G(2,"2G"),_3G(3,"3G"),_4G(4,"4G"),UNKNOW(-10,"未知");
        private Integer code;
        private String name;
        Network(Integer code,String name){
            this.code = code;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public Integer getCode() {
            return code;
        }
    }
}

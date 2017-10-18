package cn.com.bianlz.data.delivery.common;

/**
 * Created by bianlanzhou on 17/10/17.
 * Description
 */
public class ScheduleEnums{
    public enum IdeaType implements MybatisStringTypeHandlerEnum{
        PIC_WORD("1","信息流-图文"),
        _3P("2","信息流-3图"),
        BIG_PIC("3","信息流-大图"),
        DOWNLOAD_PIC_WORD("4","信息流-下载图文"),
        DOWNLOAD_BIG_PIC("5","信息流-下载大图"),
        FRESH("6","头条下拉刷新"),
        GIF("7","GIF"),
        VIDEO("8","视频"),
        START_UNCLICKABLE("9","启动页-静态不可点击"),
        START_CLICK("10","启动页-静态可点击"),
        START_VIDEO_FULL("11","启动页-全屏视频"),
        START_VIDEO("12","启动页-非全屏视频"),
        MASTER_WORD("13","邮箱大师-文本"),
        ALL_PIC_WORD("14","通投-图文"),
        ALL_3P("15","通投-三图"),
        ALL_BIG_PIC("16","通投-大图"),
        ALL_DOWNLOAD_PIC_WORD("17","通投-下载图文"),
        ALL_DOWNLOAD_BIG_PIC("18","通投-下载大图"),
        ALL_GIF_BIG("19","通投-GIF大图"),
        ALL_VIDEO("20","通投-视频"),
        UNKNOW("-10","未知");
        private String code;
        private String name;
        IdeaType(String code,String name){
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

    public enum OrderType implements MybatisStringTypeHandlerEnum{
        GD("1","保量"),
        NGD("2","不保量"),
        UNKNOW("-10","未知");
        private String code;
        private String name;
        OrderType(String code,String name){
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

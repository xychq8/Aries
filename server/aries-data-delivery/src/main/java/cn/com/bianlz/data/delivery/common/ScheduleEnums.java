package cn.com.bianlz.data.delivery.common;

/**
 * Created by bianlanzhou on 17/10/17.
 * Description
 */
public class ScheduleEnums{
    public enum IdeaType implements MybatisStringTypeHandlerEnum{
        PIC_WORD("1","信息流-图文"),
        _3P("2","信息流-三图"),
        BIG_PIC("3","信息流-大图"),
        DOWNLOAD_PIC_WORD("4","信息流-下载图文"),
        DOWNLOAD_BIG_PIC("5","信息流-下载大图"),
        FRESH("6","信息流-头条下拉刷新"),
        GIF("7","信息流-GIF"),
        VIDEO("8","信息流-视频"),
        START_UNCLICKABLE("9","启动页-静态不可点击"),
        START_CLICK("10","启动页-静态可点击"),
        START_VIDEO_FULL("11","启动页-静音全屏视频"),
        START_VIDEO("12","启动页-静音非全屏视频"),
        MASTER_WORD("13","邮箱大师-文本"),
        ALL_PIC_WORD("14","通投-图文"),
        ALL_3P("15","通投-三图"),
        ALL_BIG_PIC("16","通投-大图"),
        ALL_DOWNLOAD_PIC_WORD("17","通投-下载图文"),
        ALL_DOWNLOAD_BIG_PIC("18","通投-下载大图"),
        ALL_GIF_BIG("19","通投-GIF大图"),
        ALL_VIDEO("20","通投-视频"),
        FRONT_PASTER("21", "贴片广告-视频前贴片/视频"),
        PASTER_LARGE_PICTURE("22", "贴片广告-大图"),
        VIDEO_STREAM_LARGE_PICTURE("23", "视频栏目信息流-大图"),
        VIDEO_STREAM_DOWNLOAD_LARGE_PICTURE("24", "视频栏目信息流-下载大图"),
        VIDEO_STREAM_VIDEO("25", "视频栏目信息流-视频"),
        OPEN_CLASS_STARTUP_LARGE_PICTURE_CLICK("26", "公开课-启动页大图可点击"),
        OPEN_CLASS_STARTUP_GIF_CLICK("27", "公开课-启动页GIF可点击"),
        OPEN_CLASS_PICTURE_TEXT("28", "公开课-信息流图文"),
        OPEN_CLASS_GIF("29", "公开课-信息流GIF"),
        NEW_PICTURE_TEXT("30", "信息流-图文"),
        NEW_THREE_PICTURE("31", "信息流-三图"),
        NEW_LARGE_PICTURE("32", "信息流-大图"),
        NEW_DOWNLOAD_PICTURE_TEXT("33", "信息流-下载图文"),
        NEW_DOWNLOAD_LARGE_PICTURE("34", "信息流-下载大图"),
        NEW_GIF("35", "信息流-GIF"),
        NEW_VIDEO("36", "信息流-视频"),
        NEW_STARTUP_PICTURE_CAN_CLICK("37", "启动页-静态不可点击"),
        NEW_STARTUP_PICTURE_CANNOT_CLICK("38", "启动页-静态可点击"),
        NEW_STARTUP_VIDEO_FULL_SCREEN("39", "启动页-静音全屏视频模式-5s"),
        NEW_STARTUP_VIDEO_NON_FULL_SCREEN("40", "启动页-静音非全屏视频模式-5s"),
        NEW_COMMON_PICTURE_TEXT("41", "图文广告-图文"),
        NEW_COMMON_THREE_PICTURE("42", "图文广告-三图"),
        NEW_COMMON_LARGE_PICTURE("43", "图文广告-大图"),
        NEW_COMMON_DOWNLOAD_PICTURE_TEXT("44", "图文广告-下载图文"),
        NEW_COMMON_DOWNLOAD_LARGE_PICTURE("45", "图文广告-下载大图"),
        NEW_COMMON_GIF("46", "图文广告-GIF大图"),
        NEW_COMMON_VIDEO("47", "图文广告-视频"),
        LARGE_PICTURE_FOR_VIDEO("48", "信息流-大图(直播栏目)"),
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

    public enum CastSpeed implements MybatisStringTypeHandlerEnum{
        FAST("1","快速"),UNIFORM("2","匀速");
        private String code;
        private String name;
        CastSpeed(String code,String name){
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

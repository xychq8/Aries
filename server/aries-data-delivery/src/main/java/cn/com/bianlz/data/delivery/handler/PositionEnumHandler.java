package cn.com.bianlz.data.delivery.handler;

import cn.com.bianlz.data.delivery.common.MybatisStringTypeHandlerEnum;
import cn.com.bianlz.data.delivery.common.PositionEnums;
import cn.com.bianlz.data.delivery.common.ScheduleEnums;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bianlanzhou on 17/10/17.
 * Description
 */
public class PositionEnumHandler extends BaseTypeHandler<String> {

    private static final String COL_CHANNEL = "channel";
    private static final String UNKNOW = "未知";


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        return;
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String code = resultSet.getString(s);
        if (resultSet.wasNull()) {
            return PositionEnums.channel.UNKNOW.getName();
        } else {
            return getValue(s,code);
        }
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }

    public String getValue(String colName,String code){
        MybatisStringTypeHandlerEnum typeEnum = null;
        for(PositionEnums.channel channel:PositionEnums.channel.values()){
            if(channel.getCode().equals(code)){
                typeEnum = channel;
                break;
            }
        }
        if(typeEnum!=null){
            return typeEnum.getString();
        }
        return UNKNOW;
    }
}

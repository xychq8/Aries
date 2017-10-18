package cn.com.bianlz.data.delivery.handler;

import cn.com.bianlz.data.delivery.api.vo.Schedule;
import cn.com.bianlz.data.delivery.common.MybatisStringTypeHandlerEnum;
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
public class ScheduleEnumHandler extends BaseTypeHandler<String> {

    private static final String COL_IDEA_TYPE = "idea_type";
    private static final String COL_ORDER_TYPE = "order_type";
    private static final String COL_CAST_SPEED = "cast_speed";
    private static final String UNKNOW = "未知";


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        return;
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String code = resultSet.getString(s);
        if (resultSet.wasNull()) {
            return ScheduleEnums.IdeaType.UNKNOW.getName();
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
        if(COL_IDEA_TYPE.equals(colName)){
            for(ScheduleEnums.IdeaType ideaType: ScheduleEnums.IdeaType.values()){
                if(ideaType.getCode().equals(code)){
                    typeEnum = ideaType;
                    break;
                }
            }
        }else if(COL_ORDER_TYPE.equals(colName)){
            for(ScheduleEnums.OrderType orderType: ScheduleEnums.OrderType.values()){
                if(orderType.getCode().equals(code)){
                    typeEnum = orderType;
                    break;
                }
            }
        }else if(COL_CAST_SPEED.equals(colName)){
            for(ScheduleEnums.CastSpeed castSpeed: ScheduleEnums.CastSpeed.values()){
                if(castSpeed.getCode().equals(code)){
                    typeEnum = castSpeed;
                    break;
                }
            }
        }
        if(typeEnum!=null){
            return typeEnum.getString();
        }
        return UNKNOW;
    }
}

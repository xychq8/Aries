package cn.com.bianlz.data.delivery.handler;

import cn.com.bianlz.data.delivery.api.vo.Schedule;
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

    private ScheduleEnums.IdeaType getEnum(String code) {
        for(ScheduleEnums.IdeaType ideaType:ScheduleEnums.IdeaType.values()){
            if(ideaType.getCode().equals(code)){
                return ideaType;
            }
        }
        return ScheduleEnums.IdeaType.UNKNOW;
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String s, JdbcType jdbcType) throws SQLException {
        if(ScheduleEnums.IdeaType.valueOf(s)!=null){
            preparedStatement.setString(i, ScheduleEnums.IdeaType.valueOf(s).getName());
        }
        preparedStatement.setString(i, ScheduleEnums.IdeaType.UNKNOW.getName());
    }

    @Override
    public String getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String code = resultSet.getString(s);
        if (resultSet.wasNull()) {
            return ScheduleEnums.IdeaType.UNKNOW.getName();
        } else {
            return getEnum(code).getName();
        }
    }

    @Override
    public String getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String code = resultSet.getString(i);
        if (resultSet.wasNull()) {
            return ScheduleEnums.IdeaType.UNKNOW.getName();
        } else {
            return getEnum(code).getName();
        }
    }

    @Override
    public String getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String code = callableStatement.getString(i);
        if (code != null) {
            return getEnum(code).getName();
        }
        return ScheduleEnums.IdeaType.UNKNOW.getName();
    }
}

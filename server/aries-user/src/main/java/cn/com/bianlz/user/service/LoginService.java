package cn.com.bianlz.user.service;

import cn.com.bianlz.common.vo.Result;

/**
 * Created by bianlanzhou on 17/9/1.
 * Description
 */
public interface LoginService {
    public Result login(String username,String password);
}

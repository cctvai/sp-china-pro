package com.example.person.service;

import com.example.person.dto.LoginInDTO;
import com.example.person.dto.ZcLoginInDTO;
import com.example.person.result.Result;

/**
 * 登录服务类
 */
public interface LoginService {

    /**
     * 登录方法
     * @param inDTO
     * @return
     */
    Result login(LoginInDTO inDTO);

    /**
     * 注册方法
     * @param inDTO
     * @return
     */
    Result zclogin(ZcLoginInDTO inDTO);

}

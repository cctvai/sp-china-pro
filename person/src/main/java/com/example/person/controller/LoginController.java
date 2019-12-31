package com.example.person.controller;

import com.example.person.dto.LoginInDTO;
import com.example.person.dto.ZcLoginInDTO;
import com.example.person.result.Result;
import com.example.person.service.LoginService;
import com.example.person.utils.ExceptUtil;
import com.example.person.utils.redis.RedisKeyUtil;
import com.example.person.utils.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/user")
public class LoginController {


    @Autowired
    public LoginService loginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(LoginInDTO inDTO) {
         log.info("LoginController.login  inDTO =" + inDTO);
          return loginService.login(inDTO);
    }

    @RequestMapping(value = "/zclogin", method = RequestMethod.POST)
    @ResponseBody
    public Result zclogin(ZcLoginInDTO inDTO) {
        log.info("LoginController.zclogin  inDTO =" + inDTO);
        return loginService.zclogin(inDTO);

    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    @ResponseBody
    public Result loginOut(HttpServletRequest request) {
         log.info("LoginController.loginOut" );
         //清除Session 里面的数据
         request.getSession().removeAttribute(RedisKeyUtil.USER_INFO);
         //清除Redis 里面的数据
         RedisUtil.del( RedisKeyUtil.USER_INFO);

         return new Result(ExceptUtil.SUCCESS_CODE_200, null, null);
    }



}

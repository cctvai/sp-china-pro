package com.example.person.service.imple;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.example.person.dto.LoginInDTO;
import com.example.person.dto.UserInfoAddOrEditInDTO;
import com.example.person.dto.ZcLoginInDTO;
import com.example.person.entity.UserInfo;
import com.example.person.entity.loginResource;
import com.example.person.mapper.ResourceInfoMapper;
import com.example.person.mapper.UserInfoMapper;
import com.example.person.result.Result;
import com.example.person.service.LoginService;
import com.example.person.utils.ExceptUtil;
import com.example.person.utils.JsonParseUtil;
import com.example.person.utils.redis.RedisKeyUtil;
import com.example.person.utils.redis.RedisUtil;
import com.example.person.vo.LoginInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class LoginServiceImple implements LoginService {
    @Resource
    public UserInfoMapper userInfoMapper;
    @Resource
    public ResourceInfoMapper resourceInfoMapper;

    @Override
    public Result login(LoginInDTO inDTO) {
        LoginInfo loginInfo =new LoginInfo();
        //查看缓存里面是否存在
        String USER_INFO = RedisUtil.getStrByKey(RedisKeyUtil.USER_INFO);
        if(USER_INFO!=null && USER_INFO !=""){
            loginInfo= JsonParseUtil.LoginInfoJsonPare( USER_INFO);
            log.info("LoginController.login  缓存中存在数据 888888 USER_INFO =" + loginInfo);
            return new Result(ExceptUtil.SUCCESS_CODE_200, loginInfo, null);
        }
        log.info("LoginController.login  缓存中不存在数据 USER_INFO =" + USER_INFO);

        UserInfo userInfo= userInfoMapper.getUserInfoByLoginNo( inDTO.getLoginNo());
        if(userInfo==null){ // 账号不存在
            return new Result(ExceptUtil.LOGIN_CODE_215, userInfo, null);
        }else if(! inDTO.getUserPass().equals( userInfo.getUserPass() ) ){
            return new Result(ExceptUtil.LOGIN_CODE_225, userInfo, null);
        }
        loginInfo.setUserInfo( userInfo );
        //查询资源
        List<loginResource> resourseList= resourceInfoMapper.loginResource(inDTO.getLoginNo() );
        if ( resourseList !=null&&resourseList.size()>0){
            loginInfo.setResourseList(resourseList);
        }

        String loginInfoStr= JSON.toJSONString(loginInfo);
        //添加缓存
        RedisUtil.setStrKeyValTime(RedisKeyUtil.USER_INFO, loginInfoStr ,RedisKeyUtil.REDIS_TIME );
        log.info("LoginController.login 加入缓存数据 。。loginInfoStr ="+loginInfoStr );

        return new Result(ExceptUtil.SUCCESS_CODE_200, loginInfo, null);
    }


    @Override
    public Result zclogin(ZcLoginInDTO inDTO) {
        UserInfoAddOrEditInDTO addinDTO = new UserInfoAddOrEditInDTO();
        addinDTO.setId(IdWorker.getIdStr());
        addinDTO.setLoginNo(inDTO.getLoginNo());
        addinDTO.setUserName(inDTO.getUserName());
        addinDTO.setUserPass(inDTO.getUserPass());
        addinDTO.setUserPhone(inDTO.getUserPhone());
        addinDTO.setUserBmbh("00000000" );
        try{
            userInfoMapper.addUser( addinDTO);
            return new Result(ExceptUtil.SUCCESS_CODE_200,null,null);
        }catch (Exception e){
            return new Result(ExceptUtil.LOGIN_CODE_205,null,e.getMessage());
        }


    }
}

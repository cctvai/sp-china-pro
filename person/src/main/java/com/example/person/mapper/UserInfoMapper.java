package com.example.person.mapper;

import com.example.person.dto.UserInfoAddOrEditInDTO;
import com.example.person.dto.UserInfoInDTO;
import com.example.person.entity.UserInfo;
import com.example.person.vo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserInfoMapper {

    /**
     * 验证用户是否存在
     * @param loginNo
     * @return
     */
    UserInfo getUserInfoByLoginNo(@Param("loginNo") String loginNo);

    /**
     * 查询所有部门信息信息
     * @param inDTO
     * @return
     */
    List<UserInfoVo> queryAll(@Param("param") UserInfoInDTO inDTO);

    /**
     * 查询总数据量
     * @param inDTO
     * @return
     */
    int queryAllTotal(@Param("param") UserInfoInDTO inDTO);

    /**
     *添加
     * @param inDTO
     */
    void addUser(@Param("param") UserInfoAddOrEditInDTO inDTO);

    /**
     *编辑
     * @param inDTO
     */
    void editUser(@Param("param") UserInfoAddOrEditInDTO inDTO);
    /**
     * 删除部门
     * @param id
     */
    void delete(@Param("id") String id);
}

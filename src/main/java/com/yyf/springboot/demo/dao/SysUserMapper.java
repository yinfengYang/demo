package com.yyf.springboot.demo.dao;


import com.yyf.springboot.demo.model.SysUser;

import java.util.List;

public interface SysUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUser record);

    SysUser selectByPrimaryKey(Long id);

    List<SysUser> selectAll();

    int updateByPrimaryKey(SysUser record);

    /**
     * 分页查询用户
     * @return
     */
    List<SysUser> selectPage();
}
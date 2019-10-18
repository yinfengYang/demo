package com.yyf.springboot.demo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yyf.springboot.demo.dao.SysUserMapper;
import com.yyf.springboot.demo.model.SysUser;
import com.yyf.springboot.demo.page.PageRequest;
import com.yyf.springboot.demo.page.PageResult;
import com.yyf.springboot.demo.page.PageUtils;
import com.yyf.springboot.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService{

	@Autowired
	private SysUserMapper userMapper;

	@Override
	public SysUser findByUserId(Long userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public List<SysUser> findAll() {
		return userMapper.selectAll();
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return PageUtils.getPageResult(getPageInfo(pageRequest));
	}

	private PageInfo<SysUser> getPageInfo(PageRequest pageRequest) {
		int pageNum = pageRequest.getPageNum();
		int pageSize = pageRequest.getPageSize();
		// MyBatis 查询方法前调用 PageHelper.startPage 静态方法即可，紧跟在这个方法后的第一个MyBatis 查询方法会被进行分页。
		PageHelper.startPage(pageNum,pageSize);
		List<SysUser> sysMenus = userMapper.selectPage();
		return new PageInfo<SysUser>(sysMenus);
	}
}

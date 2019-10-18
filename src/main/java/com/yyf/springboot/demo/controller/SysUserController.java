package com.yyf.springboot.demo.controller;

import com.yyf.springboot.demo.page.PageRequest;
import com.yyf.springboot.demo.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class SysUserController {

	@Autowired
	private SysUserService userService;

	@GetMapping(value="/findByUserId")
	public Object findByUserId(@RequestParam Long userId) {
		return userService.findByUserId(userId);
	}

	@GetMapping(value="/findAll")
	public Object findAll() {
		return userService.findAll();
	}

	@PostMapping(value="/findPage")
	public Object findPage(@RequestBody PageRequest pageQuery){
		return userService.findPage(pageQuery);
	}
}
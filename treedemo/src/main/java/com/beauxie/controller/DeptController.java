package com.beauxie.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beauxie.service.DeptServiceI;
import com.beauxie.util.TreeModel;

@Controller
@RequestMapping("/deptController")
public class DeptController {

	@Resource
	private DeptServiceI deptService;

	// 表示根目录的pid
	public static final String ROOT = "00000000000000000000000000000000";

	/**
	 * 单位部门树(含部门)json
	 */
	@RequestMapping("/deptTree")
	@ResponseBody
	// 返回的是JSON格式
	public List<TreeModel> deptTree(HttpServletRequest request) {
		// 默认从根节点开始
		String id = ROOT;
		TreeModel tm = deptService.selectTree(id, true);
		return tm.getChildren();
	}
}

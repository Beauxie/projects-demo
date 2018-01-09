package com.beauxie.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.beauxie.dao.DeptMapper;
import com.beauxie.model.Dept;
import com.beauxie.service.DeptServiceI;
import com.beauxie.util.TreeModel;
import com.beauxie.util.TreeUtil;


@Service
public class DeptServiceImpl implements DeptServiceI{
	
	@Resource//或者@Autowired
	private DeptMapper deptMapper;
	

	/******************************************************** 构造单位及部门树形结构 ********************************************************/

	private List<Dept> selectChildren(String id, String type) {
		Map<String, Object> para = new HashMap<String, Object>();
		para.put("type", type);
		para.put("pid", id);
		return deptMapper.list(para);
	}

	public TreeModel selectTree(String id, boolean containsDept) {
		TreeModel tm = new TreeModel();
		
		//在此只保留部门或单位的id及name属性,可拓展
		String[] s = new String[] { "getId", "getName" };
		String type = containsDept ? "%" : "unit";
		List<Dept> li = this.selectChildren(id, type);
		this.tree(tm, li, s, containsDept);
		return tm;
	}

	// 构造组织机构树数据
	private void tree(TreeModel tm, List<Dept> li, String[] s,
			boolean containsDept) {

		if (!CollectionUtils.isEmpty(li)) {

			for (int i = 0, l = li.size(); i < l; i++) {
				TreeModel ntm = new TreeModel();
				Dept dept = li.get(i);

				TreeUtil.copyModel(ntm, dept, s);// 复制值到TreeModel
				tm.getChildren().add(ntm);// 添加到孩子节点列表

				String type = containsDept ? "%" : "unit";
				List<Dept> list = this.selectChildren(dept.getId(), type);
				tree(ntm, list, s, containsDept);// 递归，实现无限层级
			}
		}
	}

	/******************************************************** end ********************************************************/

}

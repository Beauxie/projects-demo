package com.beauxie.service;

import com.beauxie.util.TreeModel;

public interface DeptServiceI {
	

    /**
     * 返回所有的单位及部门的树形结构
    * @param id 部门id，即作为下一级子节点的pid
    * @param containsDept 是否包含子节点
    * @return TreeModel
    */
   TreeModel selectTree(String id, boolean containsDept);
}

package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.Dept;
import com.ninetowns.utils.TreeNode;

import java.util.List;

/**
 * @FileName : DeptService
 * @Author : 周翔
 * @Create Date   : 2014-06-27 20:23
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public interface DeptService {
    public List<TreeNode> queryAllTree();
    public TreeNode convert(Dept dept);

    public String[] queryDeptCodeByParentId(String deptCode);

    public Dept getById(String deptId);

    public Dept add(Dept dept);

    public String getMaxCount(String deptParentId);

    public void doUpdate(Dept dept);

    public void delete(String deptId);

    public int queryDeptCode(String deptCode);


    public List<Dept> getByPid(String orgId);
}

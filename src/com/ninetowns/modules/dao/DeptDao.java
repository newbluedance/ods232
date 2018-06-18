package com.ninetowns.modules.dao;

import com.ninetowns.core.BaseDao;
import com.ninetowns.modules.entity.Dept;
import com.ninetowns.utils.TreeNode;

import java.util.List;

/**
 * @FileName : DeptDao
 * @Author : 周翔
 * @Create Date   : 2014-06-27 20:24
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public interface DeptDao extends BaseDao<Dept> {
    public String[] queryDeptCodeByParentId(String deptCode);

    public String getMaxCount(String deptParentId);

    public List<TreeNode> queryAllTree();

    public int queryDeptCode(String deptCode);

    public List<Dept> getByPid(String orgId);
}

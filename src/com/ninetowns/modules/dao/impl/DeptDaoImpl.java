package com.ninetowns.modules.dao.impl;

import com.ninetowns.core.BaseDaoImpl;
import com.ninetowns.modules.dao.DeptDao;
import com.ninetowns.modules.entity.Dept;
import com.ninetowns.utils.TreeNode;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName : DeptDaoImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-27 20:25
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Repository("deptDao")
public class DeptDaoImpl extends BaseDaoImpl<Dept> implements DeptDao {
    @Override
    public String[] queryDeptCodeByParentId(String deptCode) {
        List<Dept> list = new ArrayList<Dept>();
        String[] array = {};
        try
        {
            list = getSqlSession().selectList("Dept.queryDeptsByDeptCode", deptCode);

            List<String> deptIds = new ArrayList<String>();

            for (Dept aList : list) {
                deptIds.add(aList.getDeptCode());
            }
            //ids = list.toArray(new String[deptIds.size()]);
            int size=deptIds.size();
            array = (String[])deptIds.toArray(new String[size]);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return array;
    }

    public String getMaxCount(String deptParentId){
        return getSqlSession().selectOne("Dept.getMaxCount", deptParentId);
    }


    @Override
    public List<TreeNode> queryAllTree() {
        return getSqlSession().selectList("Dept.queryAllTree");
    }

    @Override
    public int queryDeptCode(String deptCode) {
        return (Integer)getSqlSession().selectOne("Dept.queryDeptCode",deptCode);
    }

    @Override
    public List<Dept> getByPid(String orgId) {
        return getSqlSession().selectList("Dept.getByPid", orgId);
    }
}

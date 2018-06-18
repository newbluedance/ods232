package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.dao.DeptDao;
import com.ninetowns.modules.entity.Dept;
import com.ninetowns.modules.service.DeptService;
import com.ninetowns.utils.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

/**
 * @FileName : DeptServiceImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-27 20:24
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Transactional
@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<TreeNode> queryAllTree() {
        return deptDao.queryAllTree();
    }

    @Override
    public void doUpdate(Dept dept) {
        deptDao.modify(dept);
    }

    @Override
    public void delete(String deptId) {
        deptDao.delete(deptId);
    }
    @Override
    public int queryDeptCode(String deptCode) {
        return  deptDao.queryDeptCode(deptCode);
    }

    @Override
    public List<Dept> getByPid(String orgId) {
        return  deptDao.getByPid(orgId);
    }
    @Override
    public TreeNode convert(Dept dept) {
        TreeNode node = new TreeNode();
        node.setChecked(false);
        node.setChkDisabled(false);
        node.setClick("");
        node.setClickExpand(false);
        /*List<Dept> childern = this.getChildern(dept.getDeptId());
        if(!(childern == null || childern.size() == 0)){
            node.setDrag(false);
        }else{
            node.setDrag(true);
        }*/
        if(dept.getDeptCode().equals("3201")){
            node.setDrag(true);
        }
        node.setIcon(((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getContextPath() + "/libs/icons/user_group.gif");
        node.setIconClose("");
        node.setIconOpen("");
        node.setId(dept.getDeptCode());
        node.setDeptId(dept.getDeptId());
        node.setAddr(dept.getAddress());
        node.setMailPath(dept.getZipCode());
        node.setName(dept.getDeptName());
        node.setSort(dept.getSortIndex());
        node.setMenuType(dept.getDeptType());
        node.setParentId(String.valueOf(dept.getDeptParentId()));
        node.setOldParentId(String.valueOf(dept.getDeptParentId()));
        node.setOpen(true);
/*        node.setDesc(org.getOrgDescription());
        node.setManager(org.getOrgManager());
        node.setPhone(org.getOrgPhone());*/
        node.setExisted(true);

        return node;
    }

    @Override
    public String[] queryDeptCodeByParentId(String deptCode) {
        return deptDao.queryDeptCodeByParentId(deptCode);
    }

    @Override
    public Dept getById(String deptId) {
        return deptDao.getById(deptId);
    }

    @Override
    public Dept add(Dept dept) {
        return deptDao.add(dept);
    }

    @Override
    public String getMaxCount(String deptParentId) {
        return deptDao.getMaxCount(deptParentId);
    }

}

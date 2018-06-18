package com.ninetowns.core;

import com.ninetowns.utils.TreeNode;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName : BaseController
 * @Author : 周翔
 * @Create Date   : 2014-06-27 17:00
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public abstract class BaseController {

    @InitBinder("pager")
    public void initBinder(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("pager.");
    }

    private List<TreeNode> treeNodes = new ArrayList<TreeNode>();

    public List<TreeNode> getTreeNodes() {
        return treeNodes;
    }

    public void setTreeNodes(List<TreeNode> treeNodes) {
        this.treeNodes = treeNodes;
    }
}

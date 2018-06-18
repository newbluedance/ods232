package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.dao.ProjectDao;
import com.ninetowns.modules.entity.Project;
import com.ninetowns.modules.service.ProjectService;
import com.ninetowns.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @FileName : ProjectServiceImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:28
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Transactional
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    @Override
    public PageView queryListPage(PageView pageView, Project project) {
        List<Project> list = projectDao.queryListPage(pageView, project);
        pageView.setRows(list);
        return pageView;
    }
}

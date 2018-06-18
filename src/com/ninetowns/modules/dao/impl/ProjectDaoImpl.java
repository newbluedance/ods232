package com.ninetowns.modules.dao.impl;

import com.ninetowns.core.BaseDao;
import com.ninetowns.core.BaseDaoImpl;
import com.ninetowns.modules.dao.ProjectDao;
import com.ninetowns.modules.entity.Project;
import org.springframework.stereotype.Repository;

/**
 * @FileName : ProjectDaoImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:32
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Repository("projectDao")
public class ProjectDaoImpl extends BaseDaoImpl<Project> implements ProjectDao {
}

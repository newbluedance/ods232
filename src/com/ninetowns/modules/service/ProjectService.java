package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.Project;
import com.ninetowns.utils.PageView;

/**
 * @FileName : ProjectService
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:28
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public interface ProjectService {
    public PageView queryListPage(PageView pageView, Project project);
}

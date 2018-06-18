package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.Placard;
import com.ninetowns.utils.PageView;

/**
 * @FileName : PlacardService
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:23
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public interface PlacardService {
    public PageView queryListPage(PageView pageView, Placard placard);
}

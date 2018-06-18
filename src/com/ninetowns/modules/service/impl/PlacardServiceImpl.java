package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.dao.PlacardDao;
import com.ninetowns.modules.entity.Placard;
import com.ninetowns.modules.service.PlacardService;
import com.ninetowns.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @FileName : PlacardServiceImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:23
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Transactional
@Service("placardService")
public class PlacardServiceImpl implements PlacardService {

    @Autowired
    private PlacardDao placardDao;

    @Override
    public PageView queryListPage(PageView pageView, Placard placard) {
        List<Placard> list = placardDao.queryListPage(pageView, placard);
        pageView.setRows(list);
        return pageView;
    }
}

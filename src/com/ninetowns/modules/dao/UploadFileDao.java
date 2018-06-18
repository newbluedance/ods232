package com.ninetowns.modules.dao;

import com.ninetowns.core.BaseDao;
import com.ninetowns.modules.entity.UploadFile;

import java.util.List;

/**
 * @FileName : UserDao
 * @Author : 周翔
 * @Create Date   : 2014-06-21 10:27
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public interface UploadFileDao extends BaseDao<UploadFile> {
    public List<UploadFile>  getByIdLibs(String id);

    public void completion(UploadFile uploadFile);

    public void cancellation(UploadFile uploadFile);

    public List<UploadFile> queryList(String id);
    
    public void deleteByPathId(String id);

}

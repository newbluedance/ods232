package com.ninetowns.modules.dao.impl;

import com.ninetowns.core.BaseDaoImpl;
import com.ninetowns.modules.dao.UploadFileDao;
import com.ninetowns.modules.entity.UploadFile;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @FileName : TravellerCheckDaoImpl
 * @Author :
 * @Create Date   :
 * @Email :
 * @Last Modified :
 * @Description :
 */
@Repository("UploadFileDao")
public class UploadFileDaoImpl extends BaseDaoImpl<UploadFile> implements UploadFileDao {
    public List<UploadFile> getByIdLibs(String id) {
        return getSqlSession().selectList("UploadFile.getByIdLibs",id);
    }

    public void completion(UploadFile uploadFile){
        getSqlSession().update(this.getClassName()+".completion",uploadFile);
    }

    public void cancellation(UploadFile uploadFile){
        getSqlSession().update(this.getClassName()+".cancellation",uploadFile);
    }

    public List<UploadFile> queryList(String id) {
        return getSqlSession().selectList("UploadFile.queryList",id);
    }

	@Override
	public void deleteByPathId(String id) {
		// TODO Auto-generated method stub
		getSqlSession().delete("UploadFile.deleteByPathId",id);
	}
}

package com.ninetowns.modules.service;

import com.ninetowns.modules.entity.UploadFile;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @FileName : TravellerCheckService
 * @Author :
 * @Create Date   :
 * @Email :
 * @Last Modified :
 * @Description :
 */
public interface UploadFileService {
    public Pager query(Pager pager, UploadFile uploadFile);

    public PageView queryListPage(PageView pageView, UploadFile uploadFile);

    public List<UploadFile> queryList(String id);

    public UploadFile add(UploadFile uploadFile);

    public void modify(UploadFile uploadFile);

    public void delete(String id);
    public void deleteByPathId(String filePathId);

    public UploadFile getById(String id);

    public List<UploadFile> getByIdLibs(String id);

    public void completion(UploadFile uploadFile);

    public List<UploadFile> queryAll(UploadFile uploadFile);

    public void cancellation(UploadFile uploadFile);

    public List<UploadFile> imgsUploadBase64(HttpServletRequest request, String[] baseFile, String[] fileNameArr, String tabId, String tabName, String tabFileName, String companyFlag, String[] remark ) throws Exception;

    public String[] generateImageBase64 (String path, String filePath, String[] baseFile, String[] fileNameArr) throws Exception;

}

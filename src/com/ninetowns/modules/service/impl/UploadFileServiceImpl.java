package com.ninetowns.modules.service.impl;

import com.ninetowns.modules.dao.UploadFileDao;
import com.ninetowns.modules.entity.UploadFile;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.service.UploadFileService;
import com.ninetowns.utils.Base64Image;
import com.ninetowns.utils.Common;
import com.ninetowns.utils.PageView;
import com.ninetowns.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @FileName : UserServiceImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-21 10:26
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Transactional
@Service("UploadFileService")
public class UploadFileServiceImpl implements UploadFileService {

    @Autowired
    private UploadFileDao uploadFileDao;

    @Override
    public Pager query(Pager pager, UploadFile uploadFile) {

        return pager;
    }

    @Override
    public UploadFile add(UploadFile uploadFile) {

        uploadFileDao.add(uploadFile);
        return  uploadFile;
    }

    @Override
      public void delete(String id) {
        uploadFileDao.delete(id);
    }
    @Override
	public void deleteByPathId(String filePathId) {
    	uploadFileDao.deleteByPathId(filePathId);
		
	}

    @Override
    public void modify(UploadFile uploadFile) {
        uploadFileDao.modify(uploadFile);
    }

    @Override
    public UploadFile getById(String id) {
        return uploadFileDao.getById(id);
    }


    @Override
    public List<UploadFile> getByIdLibs(String id) {
        return uploadFileDao.getByIdLibs(id);
    }

    @Override
    public PageView queryListPage(PageView pageView, UploadFile uploadFile) {
        List<UploadFile> list = uploadFileDao.queryListPage(pageView, uploadFile);
        pageView.setRows(list);
        return pageView;
    }
    @Override
    public List<UploadFile> queryList(String id) {
        List<UploadFile> list = uploadFileDao.queryList(id);
        return list;
    }
    @Override
    public void completion(UploadFile uploadFile) {
        uploadFileDao.completion(uploadFile);
    }

    @Override
    public List<UploadFile> queryAll(UploadFile uploadFile) {
        return uploadFileDao.queryAll(uploadFile);
    }

    @Override
    public void cancellation(UploadFile uploadFile) {
        uploadFileDao.cancellation(uploadFile);
    }

    /**
     *  图片上传
     *  baseFile: base64编码后的图片数据
     *  tabId: 关联表主键id
     * */
    @Override
     public List<UploadFile> imgsUploadBase64(HttpServletRequest request, String[] baseFile, String[] fileNameArr, String tabId, String tabName, String tabFileName, String companyFlag, String[] remark ) throws Exception {
        List<UploadFile> uploadFileList = new ArrayList<UploadFile>();
        if(baseFile==null || baseFile.length==0){
            return uploadFileList;
        }
        User user = (User) request.getSession().getAttribute(Common.LOGIN_USER);
        String path  = request.getSession().getServletContext().getRealPath("upload/"+tabName+"/"+tabFileName);
        String filePath = "/upload/"+tabName+"/"+tabFileName;

//        String fileName = file.getOriginalFilename();  //原名
//        String fileType = fileName.split("\\.")[1];

        if(baseFile[0].equals("data:image/jpeg;base64")){   //仅单图特例，特殊处理
            String[] arr = new String[1];
            arr[0] = baseFile[0]+","+baseFile[1];
            baseFile = arr;
        }

        String[] imgPathArr = generateImageBase64(path, filePath, baseFile, fileNameArr);
        for(int i=0; i<imgPathArr.length; i++){
            String fileName = fileNameArr[i].substring(0, fileNameArr[i].lastIndexOf("."));  //原名
            String fileType = fileNameArr[i].substring(fileNameArr[i].lastIndexOf(".")+1);
            //新增
            UploadFile uploadFile = new UploadFile();
            uploadFile.setTabName(tabName);
            uploadFile.setTabFileName(tabFileName);
            uploadFile.setTabId(tabId);//业务逻辑层 再添加该字段数据
            uploadFile.setFileType(fileType);
            uploadFile.setFilePath(imgPathArr[i]);
            uploadFile.setFileName(fileName);
            uploadFile.setUploadDate(new Date());
            uploadFile.setUploadUser(user.getUserId());
            uploadFile.setDeleteFlag("N");
            uploadFile.setRemark(remark[i]);
            uploadFile = add(uploadFile);
            uploadFileList.add(uploadFile);
        }
        return uploadFileList;
    }

    /**
     *  批量将进过base64编码的图片数据生成图片，并放到指定路径中
     *  path: 图片存放路径
     *  baseFile ：base64编码后的图片数据
     *  return：图片路径数组
     * */
     @Override
     public String[] generateImageBase64 (String path, String filePath, String[] baseFile, String[] fileNameArr) throws Exception {
        creatFolder(path);
        String[] imgPathArr = new String[baseFile.length];
        for (int i = 0 ; i < baseFile.length ; i++){
//            String fileName = fileNameArr[i].substring(0, fileNameArr[i].lastIndexOf("."));  //原名
//            String fileType = fileNameArr[i].substring(fileNameArr[i].lastIndexOf(".")+1);
            Pattern p = Pattern.compile("data:([^;]*);base64,");
            Matcher m = p.matcher(baseFile[i]);
            String imageStr = m.replaceAll("");
//            String pathName = "";
//            if(fileType!=null && !fileType.toLowerCase().equals("gif")){
//                pathName = UUID.randomUUID().toString() + "."+fileType;  //文件名
//            }else{
//                pathName = UUID.randomUUID().toString() + ".jpg";  //文件名
//            }
            String pathName = UUID.randomUUID().toString() + ".jpg";  //文件名
            String imgPath =  path +"/"+ pathName;
            Base64Image.GenerateImage(imageStr, imgPath);
            imgPathArr[i] = filePath +"/"+ pathName;
        }
        return inversionArr(imgPathArr);
    }

    private String[] inversionArr(String[] arr){
        String[] newArr = new String[arr.length];
        for (int i = 0 ; i < arr.length ; i++){
            newArr[arr.length-i-1] = arr[i];
        }
        return newArr;
    }

    /**
     *  生成单个文件夹
     * */
    private void creatFolderSingle(String path) throws Exception{
        if(!(new java.io.File(path).isDirectory())) {
            new java.io.File(path).mkdir();
        }
    }

    /**
     *  生成路径中所有不存在的文件夹
     * */
    private void creatFolder(String path) throws Exception{
        String[] pathArr = path.split("\\\\");
        String path_1 = "";
        for(int i=0; i<pathArr.length; i++){
            if(i==0){
                path_1 += pathArr[i];
            }else{
                path_1 += "\\"+pathArr[i];
            }
            creatFolderSingle(path_1);
        }
    }

	

}

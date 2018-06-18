package com.ninetowns.modules.controller;

import com.alibaba.fastjson.JSONObject;
import com.ninetowns.core.BaseController;
import com.ninetowns.modules.entity.UploadFile;
import com.ninetowns.modules.entity.User;
import com.ninetowns.modules.service.UploadFileService;
import com.ninetowns.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: houxianghua
 * Date: 14-7-10
 * Time: 上午11:18
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/uploadFile")
public class UploadFileController extends BaseController {

    @InitBinder("uploadFile")
    public void initBinder(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("uploadFile.");
    }

    @Autowired
    private UploadFileService uploadFileService;

    @RequestMapping("addUploadFile")
    public @ResponseBody
    String addUploadFile(@RequestParam MultipartFile file, UploadFile uploadFile,String companyFlag,
                         Model model, HttpServletRequest request, HttpServletResponse response) {
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    	String date = simpleDateFormat.format(new Date());
        User user = (User) request.getSession().getAttribute(Common.LOGIN_USER);
        String path  = request.getSession().getServletContext().getRealPath("upload/"+uploadFile.getTabFileName()+"/"+date+"/"+uploadFile.getTabName());
        try {
            creatFolderAll(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String fileName = file.getOriginalFilename();  //原名
        String fileType = "";
        if(fileName.lastIndexOf(".")!=-1){
            fileType = fileName.substring(fileName.lastIndexOf(".")+1);
        }
        String pathName = UUID.randomUUID().toString()+"."+fileType;//保存路径及名称 uuid
        String filePath = "/upload/"+uploadFile.getTabFileName()+"/"+date+"/"+uploadFile.getTabName()+"/"+pathName;
        File targetFile = new File(path, pathName);

        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //新增
//        uploadFile.setTabName("T_LUGGAGE_EXAMINE");
//        uploadFile.setTabId(id);//业务逻辑层 再添加该字段数据
        
        uploadFile.setTabId(uploadFile.getTabName());//业务逻辑层 再添加该字段数据
        
        uploadFile.setFileType(fileType);
        uploadFile.setFilePath(filePath);
        uploadFile.setFileName(fileName);
        uploadFile.setUploadDate(new Date());
        if("Y".equals(companyFlag)){
        }else{
            uploadFile.setUploadUser(user.getUserId());
        }
//        uploadFile.setTabId(id);
        uploadFile.setDeleteFlag("N");
        uploadFile = uploadFileService.add(uploadFile);


        boolean isShow = true;
//        boolean isShow = false;
//        String[] imgArr = {"bmp","fits","gif","gks","rgb","itc","jpg","nif","pm","png","[e]ps","ras","tga","tif","xbm","xcf","fig","xpm","jpeg"};
//        if(fileType != null
//                && (fileType.toLowerCase().equals("jpg") || fileType.toLowerCase().equals("gif")
//                || fileType.toLowerCase().equals("png") || fileType.toLowerCase().equals("jpeg")
//                || fileType.toLowerCase().equals("bmp") || fileType.toLowerCase().equals("wbmp")
//                || fileType.toLowerCase().equals("ico") || fileType.toLowerCase().equals("jpe"))){
//            isShow = true;
//        }

        JSONObject object = new JSONObject();
        object.put("success", "true");
        object.put("isShow", isShow);
        object.put("uploadFile", uploadFile);
        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().print(JSONObject.toJSONString(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("deleteFile")
    public @ResponseBody String deleteFile(String filePathId){
        String cord = "1";
        try {
            UploadFile uploadFile = new UploadFile();
            uploadFile.setFilePathId(filePathId);
            if(filePathId!=null && !"".equals(filePathId)){
                uploadFileService.deleteByPathId(filePathId);
//                uploadFileService.cancellation(uploadFile);
            }
        } catch (Exception e) {
            cord = "0";
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return cord;
    }
    @RequestMapping("deleteFileByTabId")
    public @ResponseBody String deleteFileByTabId(String filePathId){
        String cord = "1";
        try {
            UploadFile uploadFile = new UploadFile();
            uploadFile.setFilePathId(filePathId);
            if(filePathId!=null && !"".equals(filePathId)){
                uploadFileService.delete(filePathId);
//                uploadFileService.cancellation(uploadFile);
            }
        } catch (Exception e) {
            cord = "0";
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return cord;
    }

    @RequestMapping("queryUploadFileAll")
    public @ResponseBody
    List<UploadFile> queryUploadFileAll(UploadFile uploadFile){
        List<UploadFile> uploadFileList = uploadFileService.queryAll(uploadFile);
        return uploadFileList;
    }

    private void creatFolderSingle(String path) throws Exception{
        if(!(new java.io.File(path).isDirectory())) {
            new java.io.File(path).mkdir();
        }
    }

    private void creatFolderAll(String path) throws Exception{
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

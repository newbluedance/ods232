package com.ninetowns.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * Created by Admin on 2014/9/14.
 */
public class DownLoadFile {
    public static void downloadFile(HttpServletRequest request, HttpServletResponse response, String filePath, String fileNameDisplay) {
        String filePath1 = request.getSession().getServletContext().getRealPath("");
        if(filePath.indexOf("/")==0){
            filePath = filePath1 + filePath.replace("/","\\");
        }
        // 设置为下载application/x-download
        response.setContentType("application/x-download");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileNameDisplay);
        // 中文编码转换
//        String as="我明白了.xls";
//        String fileName =as;// = java.net.URLEncoder.encode(as, "UTF-8");
//        /*根据request的locale 得出可能的编码，中文操作系统通常是gb2312*/
//        try {
//            fileName = new String(as.getBytes("GB2312"), "ISO_8859_1");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        as=fileName;
////        response.setContentType("application/vnd.ms-excel");
//        response.setHeader("Content-disposition","attachment; filename="+as+"");

        try {
            java.io.OutputStream os = response.getOutputStream();
            java.io.FileInputStream fis = new java.io.FileInputStream(filePath);
            byte[] b = new byte[1024];
            int i = 0;
            while ((i = fis.read(b)) > 0) {
                os.write(b, 0, i);
            }
            fis.close();
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO 下载完成后删除临时文件

    }
}

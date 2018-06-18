package com.ninetowns.utils;

/**
 * @FileName : WebTool
 * @Author : 周翔
 * @Create Date   : 2014-06-20 21:36
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description : 这是一个分页工具,主要用于显示页码
 *　pagecode　要获得记录的开始索引　即　开始页码
 *  pageNow 　当前页
 *　pageCount 总页数
 *  这个工具类　返回的是页索引　PageIndex
 */
public class WebTool {

    public static PageIndex getPageIndex(long pagecode, int pageNo, long totalRows){
        long startpage = pageNo-(pagecode%2==0? pagecode/2-1 : pagecode/2);
        long endpage = pageNo+pagecode/2;
        if(startpage<1){
            startpage = 1;
            if(totalRows>=pagecode) endpage = pagecode;
            else endpage = totalRows;
        }
        if(endpage>totalRows){
            endpage = totalRows;
            if((endpage-pagecode)>0) startpage = endpage-pagecode+1;
            else startpage = 1;
        }
        return new PageIndex(startpage, endpage);
    }

}

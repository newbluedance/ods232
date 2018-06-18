package com.ninetowns.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName : Pager
 * @Author : 周翔
 * @Create Date   : 2014-06-20 21:20
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :分页封装函数
 */
public class PageView {

    /**
     * 分页数据
     */
    private List rows;

    Map<String, Object> map = new HashMap<String, Object>();

    /**
     * 页码的开始索引类
     * 这个类包含，
     * startindex　开始索引
     * endindex　　结束索引
     * 这个数是计算出来的
     */
    private PageIndex pageindex;

    /**
     * 规定显示5个页码
     */
    private int pagecode = 5;

    private String sort;

    private String direction;

    private Pager pager = new Pager();

    /**
     * 使用构造函数，强制必需输入
     * 每页显示数量　和　当前页
     * @param pageNo　每页显示数量
     * @param pageSize　当前页
     */
    public PageView(int pageNo, int pageSize){
        pager.setPageSize(pageSize);
        pager.setPageNo(pageNo);
    }

    /**
     * 使用构造函数，，强制必需输入
     * 当前页
     * @param pageNo　当前页
     */
    public PageView(int pageNo){
        pager.setPageNo(pageNo);
        pager.setStartRow((pager.getPageNo() - 1) * pager.getPageSize());
    }

    /**
     * 查询结果方法
     * 把　记录数　结果集合　放入到　PageView对象
     * @param totalRows 总记录数
     * @param rows 结果集合
     */
    public void setQueryResult(long totalRows, List rows){
        setTotalRows(totalRows);
        setRows(rows);
    }

    public void setTotalRows(long totalRows) {
        pager.setTotalRows(totalRows);
        setPageCount(pager.getTotalRows() % pager.getPageSize() == 0?
                        pager.getTotalRows()/pager.getPageSize() :
                        pager.getTotalRows()/pager.getPageSize()+1
        );
    }

    /**
     * WebTool这是一个分页工具类
     * @author Administrator
     *
     *　pagecode　要获得记录的开始索引　即　开始页码
     *  pageNow 　当前页
     *　pageCount 总页数
     *
     *  这个工具类　返回的是页索引　PageIndex
     *
     *  在这个方法中存在一个问题，每页显示数量　和　当前页、、不能为空
     *  必需输入
     */
    public void setPageCount(long totalPages) {
        this.pager.setTotalPages(totalPages);
        this.pageindex = WebTool.getPageIndex(pagecode, this.pager.getPageNo(), totalPages);
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }


    public PageIndex getPageindex() {
        return pageindex;
    }

    public void setPageindex(PageIndex pageindex) {
        this.pageindex = pageindex;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public int getPagecode() {
        return pagecode;
    }

    public void setPagecode(int pagecode) {
        this.pagecode = pagecode;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}

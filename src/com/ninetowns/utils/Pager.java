package com.ninetowns.utils;

/**
 * @FileName : Pager
 * @Author : 周翔
 * @Create Date   : 2014-06-25 21:10
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
public class Pager {
    /**
     *默认 当前页 为第一页
     *这个数是计算出来的
     */
    private int pageNo = 1;

    /**
     * 总记录数
     */
    private long totalRows;

    /**
     * 每页显示几条记录
     */
    private int pageSize = 10;

    /**
     * 总页数
     * 这个数是计算出来的
     */
    private long totalPages = 0;

    /**
     * 当前页在数据库中的起始行
     */
    private int startRow;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }
}

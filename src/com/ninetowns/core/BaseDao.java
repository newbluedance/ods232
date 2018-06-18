package com.ninetowns.core;

import com.ninetowns.utils.PageView;

import java.util.List;

/**
 * @FileName : BaseDao
 * @Author : 周翔
 * @Create Date   : 2014-06-20 21:39
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :集合持久层的公用的增，删，改，查接口
 * <T> 表示传入实体类
 */
public interface BaseDao<T> {
    /**
     * 返回分页后的数据
     * @param pageView
     * @param t
     * @return
     */
    public List<T> query(PageView pageView,T t);

    public List<T> queryListPage(PageView pageView,T t);
    /**
     * 返回所有数据
     * @param t
     * @return
     */
    public List<T> queryAll(T t);
    public void delete(String id);
    public void modify(T t);
    public T getById(String id);
    public T add(T t);
}

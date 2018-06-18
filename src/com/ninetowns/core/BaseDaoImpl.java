package com.ninetowns.core;

import com.ninetowns.utils.PageView;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @FileName : BaseDaoImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-20 21:44
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :集合持久层的公用的增，删，改，查类
 * <T> 表示传入实体类
 */
public class BaseDaoImpl<T> extends SqlSessionDaoSupport {
    /**
     *
     * 获取传过来的泛型类名字
     */
    @SuppressWarnings("unchecked")
    public String getClassName(){
        //在父类中得到子类声明的父类的泛型信息
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        Class<T> clazz = (Class) pt.getActualTypeArguments()[0];
        //clazz.getSimpleName().toString().toLowerCase(); 这里是获取实体类的简单名称，再把类名转为小写
        return getStatementId(clazz);
    }

    /**
     * 获取sql标签
     *
     * @param entityClass entityClass
     * @return String
     */
    @SuppressWarnings("unchecked")
    public String getStatementId(Class entityClass)
    {
        String className = entityClass.getName();
        return className.replace(entityClass.getPackage().getName() + ".", "");
    }

    public T add(T t) {
        getSqlSession().insert(this.getClassName()+".add",t);
        return t;
    }

    public void delete(String id) {
        getSqlSession().delete(this.getClassName()+".deleteById",id);
    }

    @SuppressWarnings("unchecked")
    public T getById(String id) {
        return (T)getSqlSession().selectOne(this.getClassName()+".getById",id);
    }

    public void modify(T t) {
        getSqlSession().update(this.getClassName()+".update",t);
    }

    public List<T> query(PageView pageView,T t) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("paging", pageView);
        map.put("t", t);
        return getSqlSession().selectList(this.getClassName()+".query",map);
    }

    public List<T> queryListPage(PageView pageView,T t) {
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("paging", pageView);
        map.put("t", t);
        return getSqlSession().selectList(this.getClassName()+".queryListPage",map);
    }

    public List<T> queryAll(T t) {
        return getSqlSession().selectList(this.getClassName()+".queryAll",t);
    }


    /////////////////////////////////////
    @Resource(name = "sqlSessionFactory")
    public void setSuperSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}

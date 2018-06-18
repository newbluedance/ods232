package com.ninetowns.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import com.ninetowns.modules.entity.Menu;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  Leo
 * @version  [版本号, 2012-11-15]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class GenericUtils
{
    private static final Log log = LogFactory.getLog(GenericUtils.class);
    
    /**
     * <一句话功能简述>
     * <功能详细描述>
     * @param clazz clazz
     * @return clazz
     * @see [类、类#方法、类#成员]
     */
    @SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz)
    {
        return getSuperClassGenricType(clazz, 0);
    }
    
    /**
     * <一句话功能简述>
     * <功能详细描述>
     * @param clazz clazz
     * @param index index
     * @return class
     * @see [类、类#方法、类#成员]
     */
    @SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz, int index)
    {
        // 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
        Type genType = clazz.getGenericSuperclass();
        
        // 判断类型是否匹配
        if (!(genType instanceof ParameterizedType))
        {
            log.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
            
            return Object.class;
        }
        
        // 返回表示此类型实际类型参数的 Type 对象的数组
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        
        if (index >= params.length || index < 0)
        {
            log.warn("Index: " + index + ", Size of " + clazz.getSimpleName()
                + "'s Parameterized Type: " + params.length);
            
            return Object.class;
        }
        if (!(params[index] instanceof Class))
        {
            log.warn(clazz.getSimpleName()
                + " not set the actual class on superclass generic parameter");
            
            return Object.class;
        }
        return (Class)params[index];
    }
    
    /**
     * 批量删除组装id
     * 
     * @param ids id数组
     * @return String
     */
    public static String createBlock(Object[] ids)
    {
        if (ids == null || ids.length == 0)
        {
            return "('')";
        }
        
        String[] str = null;
        
        if (ids.length == 1)
        {
            str = ids[0].toString().split(",");
        }
        else
        {
            str = (String[])ids;
        }
        
        String blockStr = "";
        
        StringBuffer strbuf = new StringBuffer();
        
        for (int i = 0; i < str.length - 1; i++)
        {
            strbuf.append("'" + str[i] + "',");
            //blockStr += "'" + str[i] + "',";
        }
        
        strbuf.append("'" + str[str.length - 1] + "'");
        
        blockStr = strbuf.toString();
        
        //blockStr += "'" + str[str.length - 1] + "'";
        
        return blockStr;
    }
    
    /**
     * <一句话功能简述>
     * <功能详细描述>
     * @param list list
     * @return string
     * @see [类、类#方法、类#成员]
     */
    public static String fittingArray(List<String> list)
    {
        String blockStr = "";
        
        StringBuffer strbuf = new StringBuffer();
        
        for (int i = 0; i < list.size() - 1; i++)
        {
            strbuf.append("'" + list.get(i) + "',");
            //blockStr += "'" + list.get(i) + "',";
        }
        
        strbuf.append("'" + list.get(list.size() - 1) + "'");
        
        blockStr = strbuf.toString();
        //blockStr += "'" + list.get(list.size() - 1) + "'";
        
        return blockStr;
    }
    
    /**
     * 返回自动补齐数据
     * 
     * @param request request
     * @param output output
     * @return String
     */
    public static String prepareJsonOutput(HttpServletRequest request, String output)
    {
        request.setAttribute("jsonString", output);
        return "json";
    }
    
    /**
     * 获取菜单的下一个编号
     * 
     * @param menu 父类编号
     * @param totalCount
     *            以此父类编号为条件的总行数
     * @return
     *//*
    public static void getNextMenuId(Menu menu, int totalCount)
    {
        String menuId = "";
        
        StringBuilder strbuf = new StringBuilder();
        
        String parentId = menu.getMenuParentId();
        
        int ruleBefore = ResourceCommon.RULE_MENU.indexOf("-");
        
        int ruleEnd = ResourceCommon.RULE_MENU.lastIndexOf("-");
        
        // 第一次添加菜单时
        if (null == parentId || "".equals(parentId))
        {
            for (int i = 1; i <= ruleBefore; i++)
            {
                if (i == ruleBefore)
                {
                    //menuId += "1";
                    strbuf.append("1");
                    
                    break;
                }
                
                strbuf.append("1");
                //menuId += "0";
            }
            
            menuId = strbuf.toString();
        }
        else
        {
            // 如果是添加同级别的父类菜单（否则是子菜单）
            if ("0".equals(parentId))
            {
                menuId = getMenuId(ruleBefore, totalCount);
            }
            else
            {
                menuId = parentId + "-" + getMenuId(ruleEnd, totalCount);
            }
        }
        
        menu.setMenuId(menuId);
        // menu.setMenuOrder("" + (totalCount + 1));
        
    }*/
    
    /**
     * 计算下一个菜单编号
     * 
     * @param ruleIndex
     *            菜单规则
     * @param sameTotal
     *            总行数
     * @return String
     */
    public static String getMenuId(int ruleIndex, int sameTotal)
    {
        //String menuId = "";
        
        StringBuilder strbuf = new StringBuilder();
        
        int nextMenu = sameTotal + 1;
        
        int nextMenuLength = Integer.toString(nextMenu).length();
        
        int lastIndex = ruleIndex - nextMenuLength;
        
        for (int i = 1; i <= lastIndex; i++)
        {
            strbuf.append("0");
            //menuId += "0";
        }
        
        //menuId += nextMenu;
        strbuf.append(nextMenu);
        
        return strbuf.toString();
    }
    
    /**
     * <一句话功能简述>
     * <功能详细描述>
     * @param menuId menuId
     * @return String
     * @see [类、类#方法、类#成员]
     */
    public static String getMenuLevel(String menuId)
    {
        String menuLevel = "1";
        
        if (null != menuId && !"".equals(menuId))
        {
            menuLevel = String.valueOf(menuId.split("-").length);
        }
        
        return menuLevel;
    }
    
}

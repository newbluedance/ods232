package com.ninetowns.modules.dao.impl;

import com.ninetowns.core.BaseDaoImpl;
import com.ninetowns.modules.dao.UserLogDao;
import com.ninetowns.modules.entity.UserLog;
import org.springframework.stereotype.Repository;

/**
 * @FileName : UserLogDaoImpl
 * @Author : 周翔
 * @Create Date   : 2014-06-27 21:47
 * @Email : shineer@vip.qq.com
 * @Last Modified :
 * @Description :
 */
@Repository("userLogDao")
public class UserLogDaoImpl extends BaseDaoImpl<UserLog> implements UserLogDao {
}

package cn.wlgl.dao;

import cn.wlgl.vo.Manage;

/**
 * 定义管理员表的数据层操作标准
 * 
 * @author Administrator
 *
 */
public interface IManageDao {
	/**
	 * 数据的查询操作，根据账号查询出管理员的信息，并将结果包装到Manage对象中
	 * 
	 * @param username 用户的账号
	 * @return 如果查询到账号，则返回Manage对象，否则返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public Manage findByUsername(String username) throws Exception;
}

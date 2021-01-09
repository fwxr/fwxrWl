package cn.wlgl.dao;

import java.util.List;
import java.util.Set;

import cn.wlgl.vo.Person;

/**
 * 定义用户表的数据层操作标准
 * 
 * @author Administrator
 *
 */
public interface IPersonDao {
	/**
	 * 根据账号的查询出用户的信息，并将结果返回到Person对象中
	 * 
	 * @param username 用户的账号
	 * @return 如果查询到账号，则返回Person对象，否则返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public Person findByUsername(String username) throws Exception;

	/**
	 * 数据的增加操作，执行的是insert语句
	 * 
	 * @param p 包含了要增加的信息
	 * @return 如果数据增加成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public boolean doCreate(Person p) throws Exception;

	/**
	 * 数据的更新操作，执行的是update语句
	 * 
	 * @param p 包含了要更新的信息
	 * @return 如果更新成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public boolean doUpdate(Person p) throws Exception;

	/**
	 * 数据的查询操作，每行数据通过Person类包装，而后通过List保存多个返回结果
	 * 
	 * @return 全部的查询数据行，如果没有数据返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public Set<Person> findByAll() throws Exception;

}

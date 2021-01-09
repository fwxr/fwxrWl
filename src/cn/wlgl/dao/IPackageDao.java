package cn.wlgl.dao;

import java.util.List;

import cn.wlgl.vo.Package;

/**
 * 定义包裹表的数据层操作标准
 * 
 * @author Administrator
 *
 */
public interface IPackageDao {
	/**
	 * 数据的查询操作，查询用户编号的包裹，每行数据通过Package类包装，而后通过List保存多个返回结果
	 * 
	 * @param pnumber 用户的编号
	 * @return 全部的查询数据行，如果没有数据则返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public List<Package> findByPnumber(int pnumber) throws Exception;

	/**
	 * 数据的查询操作，查询快递员编号的包裹，每行数据通过Package类包装，而后通过List保存多个返回结果
	 * 
	 * @param cnumber 用户的编号
	 * @return 全部的查询数据行，如果没有数据则返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public List<Package> findByCnumber(int cnumber) throws Exception;

	/**
	 * 数据的增加操作，执行的是insert语句
	 * 
	 * @param p 包含了要增加的信息
	 * @return 如果数据增加成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public boolean doCreate(Package p) throws Exception;

	/**
	 * 数据的查询操作，每行数据通过Package类包装，而后通过List保存多个返回结果
	 * 
	 * @return 全部的查询数据行，如果没有数据返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public List<Package> findAll() throws Exception;

	/**
	 * 数据的删除操作，执行的是delete语句，通过单号删除
	 * 
	 * @param enumber 需要删除的单号
	 * @return 如果删除成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public boolean doRemove(int enumber) throws Exception;
	
	/**
	 * 数据库删除操作，删除新包裹中的数据
	 * @param enumber 需要删除的单号
	 * @return 如果删除成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public boolean doRemoveNew(int enumber) throws Exception;

	/**
	 * 数据的更新操作，执行的是update语句
	 * 
	 * @param p 需要更新的数据
	 * @return 如果更新成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public boolean doUpdate(Package p) throws Exception;

	/**
	 * 数据的查询操作，每行数据通过Package类包装，而后通过List保存多个返回结果,查询出没签收的包裹
	 * 
	 * @return 全部的查询数据行，如果没有数据返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public List<Package> findFalse() throws Exception;

	/**
	 * 数据的查询操作,根据包裹单号出包裹的信息，并将结果返回到Package对象中
	 * 
	 * @param enumber 包裹单号
	 * @return 如果查询到数据，则返回Package对象，否则返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public Package findByEnumber(int enumber) throws Exception;

	/**
	 * 数据的统计操作，执行的是count()函数，统计包裹
	 * 
	 * @param enumber 快递单号
	 * @return 返回统计结果，没有返回0
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public int countPackage(int enumber) throws Exception;

	/**
	 * 数据的查询操作，每行数据通过Package类包装，而后通过List保存多个返回结果,查询出快递员编号中未签收的包裹
	 * 
	 * @param cnumber 快递员编号
	 * @return 全部的查询数据行，如果没有数据返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public List<Package> findByCnumberFalse(int cnumber) throws Exception;

	/**
	 * 数据的查询操作，每行数据通过Package类包装，而后通过List保存多个返回结果,查询出快递员编号中已签收的包裹
	 * 
	 * @param cnumber 快递员编号
	 * @return 全部的查询数据行，如果没有数据返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public List<Package> findByCnumberTrue(int cnumber) throws Exception;

	/**
	 * 数据的修改操作，执行update语句，用于更改签收状态
	 * 
	 * @param p 需更改包裹数据
	 * @return 修改成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public boolean updateSign(Package p) throws Exception;
}

package cn.wlgl.dao;

import java.util.List;

import cn.wlgl.vo.NewPackage;

/**
 * 定义新进包裹表的数据层操作标准
 * 
 * @author Administrator
 *
 */
public interface INewPackageDao {
	/**
	 * 数据的查询操作，查询出属于用户编号的新进包裹，每行数据通过NewPackage类包装，而后通过List保存多个返回结果
	 * 
	 * @param pnumber 用户的编号
	 * @return 全部的数据查询行，如果没有数据返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public List<NewPackage> findByPnumber(int pnumber) throws Exception;

	/**
	 * 数据的查询操作,根据快递单号查询出包裹的信息，并将结果返回到NewPackage对象中
	 * 
	 * @param enumber 快递单号
	 * @return 查询的数据，如果没有数据则返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public NewPackage findByEnumber(int enumber) throws Exception;

	/**
	 * 数据的增加操作，执行的是insert语句
	 * 
	 * @param np 包含了要增加的信息
	 * @return 如果数据增加成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public boolean doCreate(NewPackage np) throws Exception;

	/**
	 * 查询表中全部数据，通过NewPackage类包装，而后通过List保存多个返回结果
	 * 
	 * @return 全部数据行，如果没有数据则返回null
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public List<NewPackage> findAll() throws Exception;

	/**
	 * 数据的删除操作，执行的是delete语句，通过单号删除表中数据
	 * 
	 * @param enumber 需要删除的单号
	 * @return 如果删除成功返回true，否则返回false
	 * @throws Exception 如果数据库没有连接，则出现NullPointerException，如果SQL语句错误抛出SQLException
	 */
	public boolean doRemove(int enumber) throws Exception;
}

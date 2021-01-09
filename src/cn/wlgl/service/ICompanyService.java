package cn.wlgl.service;

import java.util.List;

import cn.wlgl.vo.NewPackage;
import cn.wlgl.vo.Package;

public interface ICompanyService {
	/**
	 * 实现用户的登陆操作，调用的是IManageDao.findByUsername()方法，获取到Manage对象，在判断密码是否正确
	 * 
	 * @param username 用户输入账户
	 * @param password 用户输入密码
	 * @return 如果登录成功返回true，否则返回false
	 * @throws Exception IManageDao接口中抛出的异常
	 */
	public boolean Login(String username, String password) throws Exception;

	/**
	 * 用户的查询操作，调用的是INewPackageDao.findAll()方法查找NewPackage表中全部数据
	 * 
	 * @return 返回表中全部数据，如果数据不存在返回null
	 * @throws Exception INewPackageDao接口抛出的异常
	 */
	public List<NewPackage> SelectNewAll() throws Exception;


	/**
	 * 包裹的分配操作,在本操作之中需要使用INewPackageDao，PackageDao接口中的如下方法:<br>
	 * <li>首先利用INewPackageDao.findByEnumber()方法找到要分配的新进包裹,INewPackageDao.doRemove()删除新进包裹。</li>
	 * <li>修改Package对象的基本数据，然后在利用IPackageDao.doCreate()来新插入到Package表中</li>
	 * 
	 * @param enumber 需要分配的包裹单号
	 * @return 分配成功返回true，否则返回false
	 * @throws Exception INewPackageDao接口抛出的异常
	 */
	public boolean AssignNewPackage(int[] enumber) throws Exception;

	/**
	 * 用户的查询操作，调用的是IPackageDao.findAll()方法查找表中全部数据
	 * 
	 * @return 返回表中全部数据，如果数据不存在返回null
	 * @throws Exception IPackageDao接口中抛出的异常
	 */
	public List<Package> findAll() throws Exception;

	/**
	 * 用户的查询操作，调用的是IPackageDao.findFalse()方法查找表中全部未签收数据
	 * 
	 * @return 返回表中全部数据，如果数据不存在返回null
	 * @throws Exception IPackageDao接口中抛出的异常
	 */
	public List<Package> findFalse() throws Exception;

	/**
	 * 包裹表的查询操作,在本操作之中需要使用PackageDao接口中的如下方法:<br>
	 * <li>首先判断flag，如果flag=0，IPackageDao.findByEnumber()通过单号查询包裹信息</li>
	 * <li>如果flag=1，IPackageDao.findByPnumber()通过用户编号查询包裹信息</li>
	 * 
	 * @param flag   需要判断查询的类型
	 * @param number 编号
	 * @return 查询成功返回true，否则返回false
	 * @throws Exception IPackageDao接口中抛出的异常
	 */
	public List<Package> findByNumber(int flag, int number) throws Exception;

	/**
	 * 包裹的修改操作，利用需要修改的包裹的单号，来更改表的操作
	 * 
	 * @param enumber 需要更改的包裹单号
	 * @return 如果更改成功就返回true，否则返回false
	 * @throws Exception IPackageDao接口中抛出的异常
	 */
	public boolean updatePackage(int[] enumber,int c) throws Exception;

	/**
	 * 包裹的统计操作，统计未签收的包裹
	 * 
	 * @param enumber 快递单号
	 * @return 返回统计数
	 * @throws Exception IPackageDao接口中抛出的异常
	 */
	public int countPackage(int enumber) throws Exception;
	
	/**
	 * 根据快递单号查找快递具体信息
	 * 
	 * @param enumber 快递单号
	 * @return 找到数据就返回NewPackage对象，否则返回null
	 * @throws Exception INewPackageDao接口中抛出的异常
	 */
	public NewPackage findByEnumber(int enumber) throws Exception;

	/**
	 * 根据单号删除包裹表中的数据
	 * 
	 * @param enumber 需要删除的包裹单号
	 * @throws Exception IPackageDao接口中抛出的异常
	 */
	public void doRemovePackage(int enumber) throws Exception;
}

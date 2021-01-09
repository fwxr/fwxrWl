package cn.wlgl.service;

import java.util.List;
import java.util.Set;

import cn.wlgl.vo.NewPackage;
import cn.wlgl.vo.Person;
import cn.wlgl.vo.Package;

public interface IPersonService {
	/**
	 * 实现用户的登陆操作，通过账号查找出具体信息进行比较
	 * 
	 * @param username 用户输入账户
	 * @param password 用户输入密码
	 * @return 如果登录成功返回true，否则返回false
	 * @throws Exception IPersonDao接口抛出的异常
	 */
	public Person Login(String username, String password) throws Exception;

	/**
	 * 实现用户的注册操作,把Person对象插入到Person表中
	 * 
	 * @param p 需要插入的对象
	 * @return 插入成功返回true，否则返回false
	 * @throws Exception IPersonDao接口抛出的异常
	 */
	public boolean Regist(Person p) throws Exception;

	/**
	 * 实现用户修改个人信息操作
	 * 
	 * @param p 需要更改的信息
	 * @return 修改成功返回true否则返回false
	 * @throws Exception IPersonDao接口抛出的异常
	 */
	public boolean update(Person p) throws Exception;

	/**
	 * 实现用户的寄包裹操作，把数据插入到NewPackage表中
	 * 
	 * @param np 需要寄出包裹的信息
	 * @return 插入成功返回true否则返回false
	 * @throws Exception INewPackageDao接口抛出的异常
	 */
	public boolean Create(NewPackage np) throws Exception;

	/**
	 * 查找操作，通过用户编号查找到用户寄出去的新进包裹，通过NewPackage包装，而后通过List保存多个对象返回
	 * 
	 * @param pnumber 用户编号
	 * @return 返回个人包裹数据，没有则返回null
	 * @throws Exception INewPackageDao接口抛出的异常
	 */
	public List<NewPackage> SelectNew(int pnumber) throws Exception;

	/**
	 * 查找操作，通过用户编号查找到用户寄出去的包裹，通过Package包装，而后通过List保存多个对象返回
	 * 
	 * @param pnumber 用户编号
	 * @return 返回个人包裹数据，没有则返回null
	 * @throws Exception PackageDao接口抛出的异常
	 */
	public List<Package> SelectPack(int pnumber) throws Exception;

	

	/**
	 * 查找操作，查找到所有用户的信息，通过Person类包装，而后通过List保存多个对象返回
	 * 
	 * @return 返回全部数据行，没有则返回null
	 * @throws Exception IPersonDao接口抛出的异常
	 */
	public Set<Person> findByAll() throws Exception;
}

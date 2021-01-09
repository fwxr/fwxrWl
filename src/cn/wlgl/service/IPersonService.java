package cn.wlgl.service;

import java.util.List;
import java.util.Set;

import cn.wlgl.vo.NewPackage;
import cn.wlgl.vo.Person;
import cn.wlgl.vo.Package;

public interface IPersonService {
	/**
	 * ʵ���û��ĵ�½������ͨ���˺Ų��ҳ�������Ϣ���бȽ�
	 * 
	 * @param username �û������˻�
	 * @param password �û���������
	 * @return �����¼�ɹ�����true�����򷵻�false
	 * @throws Exception IPersonDao�ӿ��׳����쳣
	 */
	public Person Login(String username, String password) throws Exception;

	/**
	 * ʵ���û���ע�����,��Person������뵽Person����
	 * 
	 * @param p ��Ҫ����Ķ���
	 * @return ����ɹ�����true�����򷵻�false
	 * @throws Exception IPersonDao�ӿ��׳����쳣
	 */
	public boolean Regist(Person p) throws Exception;

	/**
	 * ʵ���û��޸ĸ�����Ϣ����
	 * 
	 * @param p ��Ҫ���ĵ���Ϣ
	 * @return �޸ĳɹ�����true���򷵻�false
	 * @throws Exception IPersonDao�ӿ��׳����쳣
	 */
	public boolean update(Person p) throws Exception;

	/**
	 * ʵ���û��ļİ��������������ݲ��뵽NewPackage����
	 * 
	 * @param np ��Ҫ�ĳ���������Ϣ
	 * @return ����ɹ�����true���򷵻�false
	 * @throws Exception INewPackageDao�ӿ��׳����쳣
	 */
	public boolean Create(NewPackage np) throws Exception;

	/**
	 * ���Ҳ�����ͨ���û���Ų��ҵ��û��ĳ�ȥ���½�������ͨ��NewPackage��װ������ͨ��List���������󷵻�
	 * 
	 * @param pnumber �û����
	 * @return ���ظ��˰������ݣ�û���򷵻�null
	 * @throws Exception INewPackageDao�ӿ��׳����쳣
	 */
	public List<NewPackage> SelectNew(int pnumber) throws Exception;

	/**
	 * ���Ҳ�����ͨ���û���Ų��ҵ��û��ĳ�ȥ�İ�����ͨ��Package��װ������ͨ��List���������󷵻�
	 * 
	 * @param pnumber �û����
	 * @return ���ظ��˰������ݣ�û���򷵻�null
	 * @throws Exception PackageDao�ӿ��׳����쳣
	 */
	public List<Package> SelectPack(int pnumber) throws Exception;

	

	/**
	 * ���Ҳ��������ҵ������û�����Ϣ��ͨ��Person���װ������ͨ��List���������󷵻�
	 * 
	 * @return ����ȫ�������У�û���򷵻�null
	 * @throws Exception IPersonDao�ӿ��׳����쳣
	 */
	public Set<Person> findByAll() throws Exception;
}

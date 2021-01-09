package cn.wlgl.service;

import java.util.List;

import cn.wlgl.vo.NewPackage;
import cn.wlgl.vo.Package;

public interface ICompanyService {
	/**
	 * ʵ���û��ĵ�½���������õ���IManageDao.findByUsername()��������ȡ��Manage�������ж������Ƿ���ȷ
	 * 
	 * @param username �û������˻�
	 * @param password �û���������
	 * @return �����¼�ɹ�����true�����򷵻�false
	 * @throws Exception IManageDao�ӿ����׳����쳣
	 */
	public boolean Login(String username, String password) throws Exception;

	/**
	 * �û��Ĳ�ѯ���������õ���INewPackageDao.findAll()��������NewPackage����ȫ������
	 * 
	 * @return ���ر���ȫ�����ݣ�������ݲ����ڷ���null
	 * @throws Exception INewPackageDao�ӿ��׳����쳣
	 */
	public List<NewPackage> SelectNewAll() throws Exception;


	/**
	 * �����ķ������,�ڱ�����֮����Ҫʹ��INewPackageDao��PackageDao�ӿ��е����·���:<br>
	 * <li>��������INewPackageDao.findByEnumber()�����ҵ�Ҫ������½�����,INewPackageDao.doRemove()ɾ���½�������</li>
	 * <li>�޸�Package����Ļ������ݣ�Ȼ��������IPackageDao.doCreate()���²��뵽Package����</li>
	 * 
	 * @param enumber ��Ҫ����İ�������
	 * @return ����ɹ�����true�����򷵻�false
	 * @throws Exception INewPackageDao�ӿ��׳����쳣
	 */
	public boolean AssignNewPackage(int[] enumber) throws Exception;

	/**
	 * �û��Ĳ�ѯ���������õ���IPackageDao.findAll()�������ұ���ȫ������
	 * 
	 * @return ���ر���ȫ�����ݣ�������ݲ����ڷ���null
	 * @throws Exception IPackageDao�ӿ����׳����쳣
	 */
	public List<Package> findAll() throws Exception;

	/**
	 * �û��Ĳ�ѯ���������õ���IPackageDao.findFalse()�������ұ���ȫ��δǩ������
	 * 
	 * @return ���ر���ȫ�����ݣ�������ݲ����ڷ���null
	 * @throws Exception IPackageDao�ӿ����׳����쳣
	 */
	public List<Package> findFalse() throws Exception;

	/**
	 * ������Ĳ�ѯ����,�ڱ�����֮����Ҫʹ��PackageDao�ӿ��е����·���:<br>
	 * <li>�����ж�flag�����flag=0��IPackageDao.findByEnumber()ͨ�����Ų�ѯ������Ϣ</li>
	 * <li>���flag=1��IPackageDao.findByPnumber()ͨ���û���Ų�ѯ������Ϣ</li>
	 * 
	 * @param flag   ��Ҫ�жϲ�ѯ������
	 * @param number ���
	 * @return ��ѯ�ɹ�����true�����򷵻�false
	 * @throws Exception IPackageDao�ӿ����׳����쳣
	 */
	public List<Package> findByNumber(int flag, int number) throws Exception;

	/**
	 * �������޸Ĳ�����������Ҫ�޸ĵİ����ĵ��ţ������ı�Ĳ���
	 * 
	 * @param enumber ��Ҫ���ĵİ�������
	 * @return ������ĳɹ��ͷ���true�����򷵻�false
	 * @throws Exception IPackageDao�ӿ����׳����쳣
	 */
	public boolean updatePackage(int[] enumber,int c) throws Exception;

	/**
	 * ������ͳ�Ʋ�����ͳ��δǩ�յİ���
	 * 
	 * @param enumber ��ݵ���
	 * @return ����ͳ����
	 * @throws Exception IPackageDao�ӿ����׳����쳣
	 */
	public int countPackage(int enumber) throws Exception;
	
	/**
	 * ���ݿ�ݵ��Ų��ҿ�ݾ�����Ϣ
	 * 
	 * @param enumber ��ݵ���
	 * @return �ҵ����ݾͷ���NewPackage���󣬷��򷵻�null
	 * @throws Exception INewPackageDao�ӿ����׳����쳣
	 */
	public NewPackage findByEnumber(int enumber) throws Exception;

	/**
	 * ���ݵ���ɾ���������е�����
	 * 
	 * @param enumber ��Ҫɾ���İ�������
	 * @throws Exception IPackageDao�ӿ����׳����쳣
	 */
	public void doRemovePackage(int enumber) throws Exception;
}

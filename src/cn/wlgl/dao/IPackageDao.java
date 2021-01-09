package cn.wlgl.dao;

import java.util.List;

import cn.wlgl.vo.Package;

/**
 * �������������ݲ������׼
 * 
 * @author Administrator
 *
 */
public interface IPackageDao {
	/**
	 * ���ݵĲ�ѯ��������ѯ�û���ŵİ�����ÿ������ͨ��Package���װ������ͨ��List���������ؽ��
	 * 
	 * @param pnumber �û��ı��
	 * @return ȫ���Ĳ�ѯ�����У����û�������򷵻�null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public List<Package> findByPnumber(int pnumber) throws Exception;

	/**
	 * ���ݵĲ�ѯ��������ѯ���Ա��ŵİ�����ÿ������ͨ��Package���װ������ͨ��List���������ؽ��
	 * 
	 * @param cnumber �û��ı��
	 * @return ȫ���Ĳ�ѯ�����У����û�������򷵻�null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public List<Package> findByCnumber(int cnumber) throws Exception;

	/**
	 * ���ݵ����Ӳ�����ִ�е���insert���
	 * 
	 * @param p ������Ҫ���ӵ���Ϣ
	 * @return ����������ӳɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public boolean doCreate(Package p) throws Exception;

	/**
	 * ���ݵĲ�ѯ������ÿ������ͨ��Package���װ������ͨ��List���������ؽ��
	 * 
	 * @return ȫ���Ĳ�ѯ�����У����û�����ݷ���null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public List<Package> findAll() throws Exception;

	/**
	 * ���ݵ�ɾ��������ִ�е���delete��䣬ͨ������ɾ��
	 * 
	 * @param enumber ��Ҫɾ���ĵ���
	 * @return ���ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public boolean doRemove(int enumber) throws Exception;
	
	/**
	 * ���ݿ�ɾ��������ɾ���°����е�����
	 * @param enumber ��Ҫɾ���ĵ���
	 * @return ���ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public boolean doRemoveNew(int enumber) throws Exception;

	/**
	 * ���ݵĸ��²�����ִ�е���update���
	 * 
	 * @param p ��Ҫ���µ�����
	 * @return ������³ɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public boolean doUpdate(Package p) throws Exception;

	/**
	 * ���ݵĲ�ѯ������ÿ������ͨ��Package���װ������ͨ��List���������ؽ��,��ѯ��ûǩ�յİ���
	 * 
	 * @return ȫ���Ĳ�ѯ�����У����û�����ݷ���null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public List<Package> findFalse() throws Exception;

	/**
	 * ���ݵĲ�ѯ����,���ݰ������ų���������Ϣ������������ص�Package������
	 * 
	 * @param enumber ��������
	 * @return �����ѯ�����ݣ��򷵻�Package���󣬷��򷵻�null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public Package findByEnumber(int enumber) throws Exception;

	/**
	 * ���ݵ�ͳ�Ʋ�����ִ�е���count()������ͳ�ư���
	 * 
	 * @param enumber ��ݵ���
	 * @return ����ͳ�ƽ����û�з���0
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public int countPackage(int enumber) throws Exception;

	/**
	 * ���ݵĲ�ѯ������ÿ������ͨ��Package���װ������ͨ��List���������ؽ��,��ѯ�����Ա�����δǩ�յİ���
	 * 
	 * @param cnumber ���Ա���
	 * @return ȫ���Ĳ�ѯ�����У����û�����ݷ���null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public List<Package> findByCnumberFalse(int cnumber) throws Exception;

	/**
	 * ���ݵĲ�ѯ������ÿ������ͨ��Package���װ������ͨ��List���������ؽ��,��ѯ�����Ա�������ǩ�յİ���
	 * 
	 * @param cnumber ���Ա���
	 * @return ȫ���Ĳ�ѯ�����У����û�����ݷ���null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public List<Package> findByCnumberTrue(int cnumber) throws Exception;

	/**
	 * ���ݵ��޸Ĳ�����ִ��update��䣬���ڸ���ǩ��״̬
	 * 
	 * @param p ����İ�������
	 * @return �޸ĳɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public boolean updateSign(Package p) throws Exception;
}

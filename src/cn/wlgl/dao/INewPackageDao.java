package cn.wlgl.dao;

import java.util.List;

import cn.wlgl.vo.NewPackage;

/**
 * �����½�����������ݲ������׼
 * 
 * @author Administrator
 *
 */
public interface INewPackageDao {
	/**
	 * ���ݵĲ�ѯ��������ѯ�������û���ŵ��½�������ÿ������ͨ��NewPackage���װ������ͨ��List���������ؽ��
	 * 
	 * @param pnumber �û��ı��
	 * @return ȫ�������ݲ�ѯ�У����û�����ݷ���null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public List<NewPackage> findByPnumber(int pnumber) throws Exception;

	/**
	 * ���ݵĲ�ѯ����,���ݿ�ݵ��Ų�ѯ����������Ϣ������������ص�NewPackage������
	 * 
	 * @param enumber ��ݵ���
	 * @return ��ѯ�����ݣ����û�������򷵻�null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public NewPackage findByEnumber(int enumber) throws Exception;

	/**
	 * ���ݵ����Ӳ�����ִ�е���insert���
	 * 
	 * @param np ������Ҫ���ӵ���Ϣ
	 * @return ����������ӳɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public boolean doCreate(NewPackage np) throws Exception;

	/**
	 * ��ѯ����ȫ�����ݣ�ͨ��NewPackage���װ������ͨ��List���������ؽ��
	 * 
	 * @return ȫ�������У����û�������򷵻�null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public List<NewPackage> findAll() throws Exception;

	/**
	 * ���ݵ�ɾ��������ִ�е���delete��䣬ͨ������ɾ����������
	 * 
	 * @param enumber ��Ҫɾ���ĵ���
	 * @return ���ɾ���ɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public boolean doRemove(int enumber) throws Exception;
}

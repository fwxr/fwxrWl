package cn.wlgl.dao;

import java.util.List;
import java.util.Set;

import cn.wlgl.vo.Person;

/**
 * �����û�������ݲ������׼
 * 
 * @author Administrator
 *
 */
public interface IPersonDao {
	/**
	 * �����˺ŵĲ�ѯ���û�����Ϣ������������ص�Person������
	 * 
	 * @param username �û����˺�
	 * @return �����ѯ���˺ţ��򷵻�Person���󣬷��򷵻�null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public Person findByUsername(String username) throws Exception;

	/**
	 * ���ݵ����Ӳ�����ִ�е���insert���
	 * 
	 * @param p ������Ҫ���ӵ���Ϣ
	 * @return ����������ӳɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public boolean doCreate(Person p) throws Exception;

	/**
	 * ���ݵĸ��²�����ִ�е���update���
	 * 
	 * @param p ������Ҫ���µ���Ϣ
	 * @return ������³ɹ�����true�����򷵻�false
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public boolean doUpdate(Person p) throws Exception;

	/**
	 * ���ݵĲ�ѯ������ÿ������ͨ��Person���װ������ͨ��List���������ؽ��
	 * 
	 * @return ȫ���Ĳ�ѯ�����У����û�����ݷ���null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public Set<Person> findByAll() throws Exception;

}

package cn.wlgl.dao;

import cn.wlgl.vo.Manage;

/**
 * �������Ա������ݲ������׼
 * 
 * @author Administrator
 *
 */
public interface IManageDao {
	/**
	 * ���ݵĲ�ѯ�����������˺Ų�ѯ������Ա����Ϣ�����������װ��Manage������
	 * 
	 * @param username �û����˺�
	 * @return �����ѯ���˺ţ��򷵻�Manage���󣬷��򷵻�null
	 * @throws Exception ������ݿ�û�����ӣ������NullPointerException�����SQL�������׳�SQLException
	 */
	public Manage findByUsername(String username) throws Exception;
}

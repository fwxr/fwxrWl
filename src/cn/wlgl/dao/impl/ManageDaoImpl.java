package cn.wlgl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.wlgl.dao.IManageDao;
import cn.wlgl.vo.Manage;

/**
 * ���Ҫ��������ݲ����࣬��ôһ��Ҫ�ڹ��췽���д���Connection�ӿڶ���
 * 
 * @author Administrator
 *
 */
public class ManageDaoImpl implements IManageDao {
	private Connection conn;
	private PreparedStatement pstmt;

	/**
	 * ʵ�������ݲ�������ͬʱ����һ�����ݿ����Ӷ���
	 * 
	 * @param conn Connection���Ӷ������Ϊnull����ʾ���ݿ�û�����ӳɹ�
	 */
	public ManageDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Manage findByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		Manage m = null;
		String sql = "select username,password from manage where username = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			m = new Manage();
			m.setUsername(rs.getString(1));
			m.setPassword(rs.getString(2));
		}
		return m;
	}

}

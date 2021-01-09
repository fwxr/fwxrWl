package cn.wlgl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.wlgl.dao.IManageDao;
import cn.wlgl.vo.Manage;

/**
 * 如果要想操作数据层子类，那么一定要在构造方法中传入Connection接口对象
 * 
 * @author Administrator
 *
 */
public class ManageDaoImpl implements IManageDao {
	private Connection conn;
	private PreparedStatement pstmt;

	/**
	 * 实例化数据操作对象，同时传入一个数据库连接对象
	 * 
	 * @param conn Connection连接对象，如果为null，表示数据库没有连接成功
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

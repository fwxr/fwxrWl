package cn.wlgl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.wlgl.dao.IPersonDao;
import cn.wlgl.vo.Person;

/**
 * 如果要想操作数据层子类，那么一定要在构造方法中传入Connection接口对象
 * 
 * @author Administrator
 *
 */
public class PersonDaoImpl implements IPersonDao {
	private Connection conn;
	private PreparedStatement pstmt;

	/**
	 * 实例化数据操作对象，同时传入一个数据库连接对象
	 * 
	 * @param conn Connection连接对象，如果为null，表示数据库没有连接成功
	 */
	public PersonDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public Person findByUsername(String username) throws Exception {
		// TODO Auto-generated method stub
		Person p = null;
		String sql = "select pnumber,username,password,name,phone,address from person where username = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			p = new Person();
			p.setPnumber(rs.getInt(1));
			p.setUsername(rs.getString(2));
			p.setPassword(rs.getString(3));
			p.setName(rs.getString(4));
			p.setPhone(rs.getString(5));
			p.setAddress(rs.getString(6));
		}
		return p;
	}

	@Override
	public boolean doCreate(Person p) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into person(pnumber,username,password,name,phone,address) values(?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, p.getPnumber());
		this.pstmt.setString(2, p.getUsername());
		this.pstmt.setString(3, p.getPassword());
		this.pstmt.setString(4, p.getName());
		this.pstmt.setString(5, p.getPhone());
		this.pstmt.setString(6, p.getAddress());
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(Person p) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update Person set password=?,name=?,phone=?,address=? where pnumber = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setString(1, p.getPassword());
		this.pstmt.setString(2, p.getName());
		this.pstmt.setString(3, p.getPhone());
		this.pstmt.setString(4, p.getAddress());
		this.pstmt.setInt(5, p.getPnumber());
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public Set<Person> findByAll() throws Exception {
		// TODO Auto-generated method stub
		Set<Person> list = new HashSet<Person>();
		String sql = "select pnumber,username,password,name,phone,address from Person";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Person p = new Person();
			p.setPnumber(rs.getInt(1));
			p.setUsername(rs.getString(2));
			p.setPassword(rs.getString(3));
			p.setName(rs.getString(4));
			p.setPhone(rs.getString(5));
			p.setAddress(rs.getString(6));
			list.add(p);
		}
		return list;
	}

}

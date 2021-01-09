package cn.wlgl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.wlgl.dao.INewPackageDao;
import cn.wlgl.vo.NewPackage;

/**
 * 如果要想操作数据层子类，那么一定要在构造方法中传入Connection接口对象
 * 
 * @author Administrator
 *
 */
public class NewPackageDaoImpl implements INewPackageDao{
	private Connection conn;
	private PreparedStatement pstmt;

	/**
	 * 实例化数据层子类对象，同时传入一个数据库连接对象
	 * 
	 * @param conn Connection连接对象，如果为null表示数据库没有打开
	 */
	public NewPackageDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<NewPackage> findByPnumber(int pnumber) throws Exception {
		// TODO Auto-generated method stub
		List<NewPackage> list = new ArrayList<NewPackage>();
		String sql = "select enumber,pnumber,sendaddress,getaddress,sendtime,phone from newpackage where pnumber = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.setInt(1, pnumber);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			NewPackage np = new NewPackage();
			np.setEnumber(rs.getInt(1));
			np.setPnumber(rs.getInt(2));
			np.setSendaddress(rs.getString(3));
			np.setGetaddress(rs.getString(4));
			np.setSendtime(rs.getDate(5));
			np.setPhone(rs.getString(6));
			list.add(np);
		}
		return list;
	}

	@Override
	public boolean doCreate(NewPackage np) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into newpackage(enumber,pnumber,sendaddress,getaddress,sendtime,phone) values(?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, np.getEnumber());
		this.pstmt.setInt(2, np.getPnumber());
		this.pstmt.setString(3, np.getSendaddress());
		this.pstmt.setString(4, np.getGetaddress());
		this.pstmt.setDate(5, np.getSendtime());
		this.pstmt.setString(6, np.getPhone());
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public List<NewPackage> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<NewPackage> list = new ArrayList<NewPackage>();
		String sql = "select enumber,pnumber,sendaddress,getaddress,sendtime,phone from newpackage";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			NewPackage np = new NewPackage();
			np.setEnumber(rs.getInt(1));
			np.setPnumber(rs.getInt(2));
			np.setSendaddress(rs.getString(3));
			np.setGetaddress(rs.getString(4));
			np.setSendtime(rs.getDate(5));
			np.setPhone(rs.getString(6));
			list.add(np);
		}
		return list;
	}

	@Override
	public boolean doRemove(int enumber) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from newpackage where enumber = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, enumber);
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public NewPackage findByEnumber(int enumber) throws Exception {
		// TODO Auto-generated method stub
		NewPackage np = null;
		String sql = "select enumber,pnumber,sendaddress,getaddress,sendtime,phone from newpackage where enumber = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, enumber);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			np = new NewPackage();
			np.setEnumber(rs.getInt(1));
			np.setPnumber(rs.getInt(2));
			np.setSendaddress(rs.getString(3));
			np.setGetaddress(rs.getString(4));
			np.setSendtime(rs.getDate(5));
			np.setPhone(rs.getString(6));
		}
		return np;
	}

}

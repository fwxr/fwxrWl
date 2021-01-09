package cn.wlgl.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.wlgl.dao.IPackageDao;
import cn.wlgl.vo.Package;

/**
 * 如果要想操作数据层子类，那么一定要在构造方法中传入Connection接口对象
 * 
 * @author Administrator
 *
 */
public class PackageDaoImpl implements IPackageDao {
	private Connection conn;
	private PreparedStatement pstmt;

	/**
	 * 实例化数据层子类对象，同时传入一个数据库连接对象
	 * 
	 * @param conn Connection连接对象，如果为null表示数据库没有打开
	 */
	public PackageDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Package> findByPnumber(int pnumber) throws Exception {
		// TODO Auto-generated method stub
		List<Package> list = new ArrayList<Package>();
		String sql = "select enumber,pnumber,sendaddress,getaddress,sendtime,gettime,money,phone,sign from package where pnumber = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.setInt(1, pnumber);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Package p = new Package();
			p.setEnumber(rs.getInt(1));
			p.setPnumber(rs.getInt(2));
			p.setSendaddress(rs.getString(3));
			p.setGetaddress(rs.getString(4));
			p.setSendtime(rs.getDate(5));
			p.setGettime(rs.getDate(6));
			p.setMoney(rs.getFloat(7));
			p.setPhone(rs.getString(8));
			p.setSign(rs.getBoolean(9));
			list.add(p);
		}
		return list;
	}

	@Override
	public List<Package> findByCnumber(int cnumber) throws Exception {
		// TODO Auto-generated method stub
		List<Package> list = new ArrayList<Package>();
		String sql = "select enumber,pnumber,sendaddress,getaddress,sendtime,gettime,money,phone,sign from package where cnumber = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.setInt(1, cnumber);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Package p = new Package();
			p.setEnumber(rs.getInt(1));
			p.setPnumber(rs.getInt(2));
			p.setSendaddress(rs.getString(3));
			p.setGetaddress(rs.getString(4));
			p.setSendtime(rs.getDate(5));
			p.setGettime(rs.getDate(6));
			p.setMoney(rs.getFloat(7));
			p.setPhone(rs.getString(8));
			p.setSign(rs.getBoolean(9));
			list.add(p);
		}
		return list;
	}

	@Override
	public boolean doCreate(Package p) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into package(enumber,pnumber,sendaddress,getaddress,sendtime,gettime,money,phone,sign) values(?,?,?,?,?,?,?,?,?)";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, p.getEnumber());
		this.pstmt.setInt(2, p.getPnumber());
		this.pstmt.setString(3, p.getSendaddress());
		this.pstmt.setString(4, p.getGetaddress());
		this.pstmt.setDate(5, p.getSendtime());
		this.pstmt.setDate(6, p.getGettime());
		this.pstmt.setFloat(7, p.getMoney());
		this.pstmt.setString(8, p.getPhone());
		this.pstmt.setBoolean(9, p.getSign());
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public List<Package> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Package> list = new ArrayList<Package>();
		String sql = "select enumber,pnumber,sendaddress,getaddress,sendtime,gettime,money,phone,sign from package";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Package p = new Package();
			p.setEnumber(rs.getInt(1));
			p.setPnumber(rs.getInt(2));
			p.setSendaddress(rs.getString(3));
			p.setGetaddress(rs.getString(4));
			p.setSendtime(rs.getDate(5));
			p.setGettime(rs.getDate(6));
			p.setMoney(rs.getFloat(7));
			p.setPhone(rs.getString(8));
			p.setSign(rs.getBoolean(9));
			list.add(p);
		}
		return list;
	}

	@Override
	public boolean doRemove(int enumber) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from package where enumber = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, enumber);
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public boolean doUpdate(Package p) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update package set gettime=?,money=?,sign=? where enumber = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setDate(1, p.getGettime());
		this.pstmt.setFloat(2, p.getMoney());
		this.pstmt.setBoolean(3, p.getSign());
		this.pstmt.setInt(4, p.getEnumber());
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public List<Package> findFalse() throws Exception {
		// TODO Auto-generated method stub
		List<Package> list = new ArrayList<Package>();
		String sql = "select enumber,pnumber,sendaddress,getaddress,sendtime,gettime,money,phone,sign from package where sign = 'False'";
		this.pstmt = this.conn.prepareStatement(sql);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Package p = new Package();
			p.setEnumber(rs.getInt(1));
			p.setPnumber(rs.getInt(2));
			p.setSendaddress(rs.getString(3));
			p.setGetaddress(rs.getString(4));
			p.setSendtime(rs.getDate(5));
			p.setGettime(rs.getDate(6));
			p.setMoney(rs.getFloat(7));
			p.setPhone(rs.getString(8));
			p.setSign(rs.getBoolean(9));
			list.add(p);
		}
		return list;
	}

	@Override
	public Package findByEnumber(int enumber) throws Exception {
		// TODO Auto-generated method stub
		Package p = null;
		String sql = "select enumber,pnumber,sendaddress,getaddress,sendtime,gettime,money,phone,sign from package where enumber = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		pstmt.setInt(1, enumber);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			p = new Package();
			p.setEnumber(rs.getInt(1));
			p.setPnumber(rs.getInt(2));
			p.setSendaddress(rs.getString(3));
			p.setGetaddress(rs.getString(4));
			p.setSendtime(rs.getDate(5));
			p.setGettime(rs.getDate(6));
			p.setMoney(rs.getFloat(7));
			p.setPhone(rs.getString(8));
			p.setSign(rs.getBoolean(9));
		}
		return p;
	}

	@Override
	public int countPackage(int enumber) throws Exception {
		// TODO Auto-generated method stub
		int sum = 0;
		String sql = "select count(enumber) from package where enumber = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, enumber);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			sum = rs.getInt(1);
		}
		return sum;
	}

	@Override
	public List<Package> findByCnumberFalse(int cnumber) throws Exception {
		// TODO Auto-generated method stub
		List<Package> list = new ArrayList<Package>();
		String sql = "select enumber,pnumber,sendaddress,getaddress,sendtime,gettime,money,phone,sign from package where cnumber = ? and sign = 'False'";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, cnumber);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Package p = new Package();
			p.setEnumber(rs.getInt(1));
			p.setPnumber(rs.getInt(2));
			p.setSendaddress(rs.getString(3));
			p.setGetaddress(rs.getString(4));
			p.setSendtime(rs.getDate(5));
			p.setGettime(rs.getDate(6));
			p.setMoney(rs.getFloat(7));
			p.setPhone(rs.getString(8));
			p.setSign(rs.getBoolean(9));
			list.add(p);
		}
		return list;
	}

	@Override
	public boolean updateSign(Package p) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update package set gettime=getDate(),sign=? where enumber = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setBoolean(1, p.getSign());
		this.pstmt.setInt(2, p.getEnumber());
		return this.pstmt.executeUpdate() > 0;
	}

	@Override
	public List<Package> findByCnumberTrue(int cnumber) throws Exception {
		// TODO Auto-generated method stub
		List<Package> list = new ArrayList<Package>();
		String sql = "select enumber,pnumber,sendaddress,getaddress,sendtime,gettime,money,phone,sign from package where cnumber = ? and sign = 'True'";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, cnumber);
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Package p = new Package();
			p.setEnumber(rs.getInt(1));
			p.setPnumber(rs.getInt(2));
			p.setSendaddress(rs.getString(3));
			p.setGetaddress(rs.getString(4));
			p.setSendtime(rs.getDate(5));
			p.setGettime(rs.getDate(6));
			p.setMoney(rs.getFloat(7));
			p.setPhone(rs.getString(8));
			p.setSign(rs.getBoolean(9));
			list.add(p);
		}
		return list;
	}

	@Override
	public boolean doRemoveNew(int enumber) throws Exception {
		// TODO Auto-generated method stub
		String sql = "delete from newpackage where enumber = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, enumber);
		return this.pstmt.executeUpdate() > 0;
	}

}

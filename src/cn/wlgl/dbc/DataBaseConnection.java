package cn.wlgl.dbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.*;

import java.sql.*;

/**
 * 本类负责数据库的连接操作，在进行本类对象实例化时，自动进行数据库连接处理
 * 
 * @author Administrator
 *
 */
public class DataBaseConnection {
	private static  String DBDRIVER;//"com.mysql.cj.jdbc.Driver";
	private static  String DBURL;//"jdbc:mysql://localhost:3306;t?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
	private static  String DBUSER;//"root";
	private static  String PASSWORD;//"123456";
	private Connection conn = null;

	/**
	 * 在构造方法调用时将取得数据库的连接对象
	 */
	public DataBaseConnection() {
		try {
			//创建Properties类
			Properties pro = new Properties();
			//加载文件
			pro.load(new FileReader("D:\\java\\java习题\\Wl\\jdbc.properties"));
			//赋值
			DBDRIVER=pro.getProperty("DBDRIVER");
			DBURL=pro.getProperty("DBURL");
			DBUSER=pro.getProperty("DBUSER");
            PASSWORD=pro.getProperty("PASSWORD");
            
			Class.forName(DBDRIVER);// 加载数据库的驱动程序
			
			this.conn = DriverManager.getConnection(DBURL, DBUSER,PASSWORD);
		} 
		
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 取得数据库连接对象
	 * 
	 * @return 实例化的Connection对象，如果返回null，表示连接失败。
	 */
	public Connection getConnection() {
		return this.conn;
	}

	/**
	 * 进行数据库的关闭操作
	 */
	public void close() {
		if (this.conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

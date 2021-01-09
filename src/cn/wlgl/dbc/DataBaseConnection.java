package cn.wlgl.dbc;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import java.sql.*;

import java.sql.*;

/**
 * ���ฺ�����ݿ�����Ӳ������ڽ��б������ʵ����ʱ���Զ��������ݿ����Ӵ���
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
	 * �ڹ��췽������ʱ��ȡ�����ݿ�����Ӷ���
	 */
	public DataBaseConnection() {
		try {
			//����Properties��
			Properties pro = new Properties();
			//�����ļ�
			pro.load(new FileReader("D:\\java\\javaϰ��\\Wl\\jdbc.properties"));
			//��ֵ
			DBDRIVER=pro.getProperty("DBDRIVER");
			DBURL=pro.getProperty("DBURL");
			DBUSER=pro.getProperty("DBUSER");
            PASSWORD=pro.getProperty("PASSWORD");
            
			Class.forName(DBDRIVER);// �������ݿ����������
			
			this.conn = DriverManager.getConnection(DBURL, DBUSER,PASSWORD);
		} 
		
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ȡ�����ݿ����Ӷ���
	 * 
	 * @return ʵ������Connection�����������null����ʾ����ʧ�ܡ�
	 */
	public Connection getConnection() {
		return this.conn;
	}

	/**
	 * �������ݿ�Ĺرղ���
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

package cn.util;

import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil {
	private static final String jdbcUrl="jdbc:mysql://localhost:3306/31801143?useUnicode=true&characterEncoding=utf-8";
	private static final String dbUser="root";
	private static final String dbPwd="123456";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws java.sql.SQLException{
		return java.sql.DriverManager.getConnection(jdbcUrl, dbUser, dbPwd);
	}
	
	
	/**
	 * 关闭数据库连接
	 */
	public void  closeCon(Connection con) throws Exception{
		if(con!=null) {
			con.close();
		}
	}
	public static void main(String[] args) {
		DbUtil dbUtil=new DbUtil();
		try {
			dbUtil.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


package cn.edu.sdut.test.testConn;

import java.sql.Connection;
import java.sql.SQLException;

import cn.edu.sdut.comm.datasource.util.JDBCUtils;

public class TestConn {
	public static void main(String[] args) {
		testConn();
	}

	private static void testConn() {
		try {
			Connection conn = JDBCUtils.getConnection();
			if(conn!=null)
			{
				System.out.println("success");
			}
			else
			{
				System.out.println("failed");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package cn.dao;

import java.sql.SQLException;


import cn.model.*;
import cn.view.*;
import cn.util.*;


public class userManager {
	//关于用户的注册、登录
	public User2 reg(String user_name,String sex,String pwd) throws BaseException {
		
		
		java.sql.Connection conn=null;
		
		try {
			conn = DbUtil.getConnection();
			String sql = "select max(user_id) from user";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();
			int user_id = 0;
			if (rs.next()) user_id = rs.getInt(1) + 1;
			
			sql = "insert into user values(?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, user_id);
			pst.setString(2, pwd);
			
			pst.execute();
			User2 zwx = new User2();
			zwx.setUser_id(user_id);
			zwx.setUser_name(user_name);
			zwx.setUser_pwd(pwd);
			
			
			return zwx;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	
	
	
	public User2 login(int userid,String pwd) throws BaseException {
		java.sql.Connection conn=null;
		try {
			User2 zwx = new User2();
			conn=DbUtil.getConnection();
			String sql = "select user_pwd from user where user_id = " + userid;
			System.out.println(sql);
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();
			boolean f = false;
			while (rs.next()) {
				zwx.setUser_pwd(rs.getString(1));
				f = true;
			}
			if (f==false) throw new BaseException("用户不存在");
			if (!pwd.equals(zwx.getUser_pwd())) throw new BaseException("密码错误");
			
			
			zwx.setUser_id(userid);
			
			
			rs.close();
			pst.close();
			return zwx;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(e);
		}
		finally{
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
		
	}
}

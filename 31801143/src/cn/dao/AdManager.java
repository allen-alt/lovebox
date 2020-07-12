package cn.dao;

import java.sql.SQLException;


import cn.model.*;
import cn.view.*;
import cn.util.*;


public class AdManager {
	//关于管理员的注册、登录
	public User reg(String stuff_name,String pwd) throws BaseException {
		
		
		java.sql.Connection conn=null;
		
		try {
			conn = DbUtil.getConnection();
			String sql = "select max(stuff_id) from administrator";
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();
			int stuff_id = 0;
			if (rs.next()) stuff_id = rs.getInt(1) + 1;
			
			sql = "insert into administrator values(?,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, stuff_id);
			pst.setString(2, stuff_name);
			pst.setString(3, pwd);
			
			
			pst.execute();
			User zwx = new User();
			zwx.setAd_id(stuff_id);
			zwx.setAd_name(stuff_name);
			zwx.setAd_pwd(pwd);
			
			
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
	
	
	
	
	public User login(int stuffid, String pwd) throws BaseException {
		java.sql.Connection conn=null;
		try {
			User zwx = new User();
			conn=DbUtil.getConnection();
			String sql = "select pwd from user where stuff_id = " + stuffid;
			System.out.println(sql);
			java.sql.PreparedStatement pst = conn.prepareStatement(sql);
			java.sql.ResultSet rs = pst.executeQuery();
			boolean f = false;
			while (rs.next()) {
				zwx.setAd_pwd(rs.getString(1));
				f = true;
			}
			if (f==false) throw new BaseException("用户不存在");
			if (!pwd.equals(zwx.getAd_pwd())) throw new BaseException("密码错误");
			
			
			zwx.setAd_id(stuffid);
			
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

package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.model.SxType;
import cn.util.StringUtil;

public class SxTypeDao {
	
	public int add(Connection con,SxType sxType)throws Exception{
		String sql="insert into sxType values(null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,sxType.getSxTypeName());
		pstmt.setString(2,sxType.getSxTypeName());
		
		return pstmt.executeUpdate();
	}
	
	/**
	 * 查询生鲜类别
	 * @param con
	 * @param sxType
	 * @return
	 * @throws Exception
	 */
	public ResultSet list(Connection con,SxType sxType)throws Exception{
		StringBuffer sb=new StringBuffer("select * from sxType");
		if(StringUtil.isNotempty(sxType.getSxTypeName())) {
			sb.append(" and sxTypeName like '%"+sxType.getSxTypeName()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString().replaceFirst("and","where"));
		return pstmt.executeQuery();
	}

}

package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import cn.model.Goods;

public class GoodsDao {
	
	/**
	 * 商品添加
	 * @param con
	 * @param goods
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Goods goods)throws Exception{
		String sql="insert into goods values(null,?,?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,goods.getGoodsName());
		pstmt.setFloat(2,goods.getPrice());
		pstmt.setFloat(3,goods.getVipprice());
		pstmt.setInt(4,goods.getAmount());
		pstmt.setString(5,goods.getGuige());
		pstmt.setString(6,goods.getGoodsDesc());
		pstmt.setInt(7,goods.getGoodsTypeId());
		return pstmt.executeUpdate();
	}

}

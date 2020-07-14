package cn.edu.sdut.goodsType.dao.impl;

import java.util.List;

import cn.edu.sdut.comm.base.dao.BaseDaoImpl;
import cn.edu.sdut.goodsType.dao.GoodsTypeDao;
import cn.edu.sdut.goodsType.entity.GoodsType;

public class GoodsTypeDaoImpl extends BaseDaoImpl<GoodsType> implements GoodsTypeDao {

	@Override
	public GoodsType queryTypeById(Integer typeid) {
		String sql = "select * from category where typeid=?";
		return super.selectOne(sql, GoodsType.class, typeid);
	}

	@Override
	public List<GoodsType> queryAllType() {
		String sql = "SELECT * FROM category";
		return super.selectAll(sql, GoodsType.class, null);
	}

	
	
}

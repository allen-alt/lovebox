package cn.edu.sdut.goodsType.dao;

import java.util.List;

import cn.edu.sdut.goodsType.entity.GoodsType;

public interface GoodsTypeDao {
	
	GoodsType queryTypeById(Integer typeid);
	
	List<GoodsType> queryAllType();
}

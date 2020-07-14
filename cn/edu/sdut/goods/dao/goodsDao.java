package cn.edu.sdut.goods.dao;

import java.util.List;

import cn.edu.sdut.goods.entity.Goods;

public interface goodsDao {
	
	List<Goods> queryAllGoods(Goods goods);
	Goods queryGoodsById(Integer goodsid);
	int updateGoods(Goods goods);
	//新增商品
	int addGoods(Goods goods);
	//删除商品
	int deleteGoods(Integer goodsid);
}

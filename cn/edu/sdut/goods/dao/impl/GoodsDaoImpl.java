package cn.edu.sdut.goods.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.edu.sdut.comm.base.dao.BaseDaoImpl;
import cn.edu.sdut.goods.dao.goodsDao;
import cn.edu.sdut.goods.entity.Goods;

public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements goodsDao {

	@Override
	public List<Goods> queryAllGoods(Goods goods) {
		String sql = "select * from goods ";
		//order by gradeid desc
		StringBuffer sb = new StringBuffer();
		sb.append(sql);
		List<Object> list = new ArrayList<Object>();
		if(goods!=null && goods.getGoodsname()!=null && !goods.getGoodsname().isEmpty())
		{
			sb.append("where goodsname like ?");
			list.add("%"+goods.getGoodsname()+"%");
			if(goods!=null && goods.getCateid()!=null&& goods.getCateid()>0)
			{
				sb.append(" and cateid=?");
				list.add(goods.getCateid());
			}
			
		}
		else
		{
			if(goods!=null && goods.getCateid()!=null&& goods.getCateid()>0)
			{
				sb.append(" where cateid=?");
				list.add(goods.getCateid());
			}
		}
		sb.append(" order by goodsid asc");
		sql=sb.toString();
		return super.selectAll(sql, Goods.class, list.toArray());
	}

	@Override
	public Goods queryGoodsById(Integer goodsid) {
		String sql = "SELECT * FROM goods WHERE goodsid=?";
		return super.selectOne(sql, Goods.class, goodsid);
	}

	@Override
	public int updateGoods(Goods goods) {
		String sql = "UPDATE goods SET num=? WHERE goodsid=?";
		return super.saveOrUpdate(sql, goods.getNum(),goods.getGoodsid());
	}

	@Override
	public int addGoods(Goods goods) {
		String sql = "INSERT INTO goods VALUES(NULL,?,?,?,?)";
		return super.saveOrUpdate(sql, goods.getCateid(),goods.getGoodsname(),goods.getPrice(),goods.getNum());
	}

	@Override
	public int deleteGoods(Integer goodsid) {
		String sql = "DELETE FROM goods WHERE goodsid=?";
		return super.saveOrUpdate(sql, goodsid);
	}

	

}

package cn.edu.sdut.bill.dao.Imlp;

import java.util.List;

import cn.edu.sdut.bill.dao.BillDao;
import cn.edu.sdut.bill.entity.Bill;
import cn.edu.sdut.comm.base.dao.BaseDaoImpl;

public class BillDaoImpl extends BaseDaoImpl<Bill> implements BillDao {

	@Override
	public int addBill(Bill bill) {
		String sql = "INSERT INTO bill VALUES(NULL,?,?,?,?,?,?,?,?,?)";
		return super.saveOrUpdate(sql, bill.getUserid(),bill.getBuygoodsname(),bill.getBuygoodsprice(),bill.getBuygoodsnum(),bill.getBilltotalprice(),bill.getBilltime(),bill.getTel(),bill.getAddress(),bill.getSendtype());
	}


	@Override
	public List<Bill> queryAllBill(Bill bill) {
		String sql = "SELECT * FROM bill WHERE userid=?";
		return super.selectAll(sql, Bill.class, bill.getUserid());
	}
	
	@Override
	public int deleteBill(Integer billid) {
		String sql = "DELETE FROM bill WHERE billid=?";
		return super.saveOrUpdate(sql, billid);
	}


	@Override
	public Bill queryOneBill(Integer billid) {
		String sql = "SELECT * FROM bill WHERE billid=?";
		return super.selectOne(sql, Bill.class, billid);
	}
	
	
}

package cn.edu.sdut.bill.dao;

import java.util.List;

import cn.edu.sdut.bill.entity.Bill;


public interface BillDao {
	
	int addBill(Bill bill);
	//查询多条记录
	List<Bill> queryAllBill(Bill bill);
	Bill queryOneBill(Integer billid);
	int deleteBill(Integer billid);
}

package cn.edu.sdut.bill.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Bill {
	private String address,tel,buygoodsname;
	private Double billtotalprice,buygoodsprice;
	private Date billtime;
	private Integer billid,userid,buygoodsnum,sendtype;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBuygoodsname() {
		return buygoodsname;
	}
	public void setBuygoodsname(String buygoodsname) {
		this.buygoodsname = buygoodsname;
	}
	public Double getBilltotalprice() {
		return billtotalprice;
	}
	public void setBilltotalprice(Double billtotalprice) {
		this.billtotalprice = billtotalprice;
	}
	public Double getBuygoodsprice() {
		return buygoodsprice;
	}
	public void setBuygoodsprice(Double buygoodsprice) {
		this.buygoodsprice = buygoodsprice;
	}
	public Date getBilltime() {
		return billtime;
	}
	public void setBilltime(Date billtime) {
		this.billtime = billtime;
	}
	public Integer getBillid() {
		return billid;
	}
	public void setBillid(Integer billid) {
		this.billid = billid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getBuygoodsnum() {
		return buygoodsnum;
	}
	public void setBuygoodsnum(Integer buygoodsnum) {
		this.buygoodsnum = buygoodsnum;
	}
	public Integer getSendtype() {
		return sendtype;
	}
	public void setSendtype(Integer sendtype) {
		this.sendtype = sendtype;
	}
	
	
}

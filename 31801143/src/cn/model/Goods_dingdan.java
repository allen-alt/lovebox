package cn.model;

public class Goods_dingdan {
	private int dingdan_id;
	private int user_id;
	private String yuanshi_money;
	private String jiesuan_money;
	private int coupon_id;
	private java.util.Date deliver_time;
	private String state;
	public int getDingdan_id() {
		return dingdan_id;
	}
	public void setDingdan_id(int dingdan_id) {
		this.dingdan_id = dingdan_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getYuanshi_money() {
		return yuanshi_money;
	}
	public void setYuanshi_money(String yuanshi_money) {
		this.yuanshi_money = yuanshi_money;
	}
	public String getJiesuan_money() {
		return jiesuan_money;
	}
	public void setJiesuan_money(String jiesuan_money) {
		this.jiesuan_money = jiesuan_money;
	}
	public int getCoupon_id() {
		return coupon_id;
	}
	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}
	public java.util.Date getDeliver_time() {
		return deliver_time;
	}
	public void setDeliver_time(java.util.Date deliver_time) {
		this.deliver_time = deliver_time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}

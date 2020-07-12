package cn.model;

public class Goods {
	private int id;
	private String goodsName;
	private Float price;
	private Float vipprice;
	private int amount;
	private String guige;
	private String goodsDesc;
	private Integer goodsTypeId;
	private String sxTypeName;
	
	
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Goods(String goodsName, Float price, Float vipprice, int amount, String guige, String goodsDesc,
			Integer goodsTypeId) {
		super();
		this.goodsName = goodsName;
		this.price = price;
		this.vipprice = vipprice;
		this.amount = amount;
		this.guige = guige;
		this.goodsDesc = goodsDesc;
		this.goodsTypeId = goodsTypeId;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getVipprice() {
		return vipprice;
	}
	public void setVipprice(Float vipprice) {
		this.vipprice = vipprice;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getGuige() {
		return guige;
	}
	public void setGuige(String guige) {
		this.guige = guige;
	}
	public String getGoodsDesc() {
		return goodsDesc;
	}
	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}
	public Integer getGoodsTypeId() {
		return goodsTypeId;
	}
	public void setGoodsTypeId(Integer goodsTypeId) {
		this.goodsTypeId = goodsTypeId;
	}
	public String getSxTypeName() {
		return sxTypeName;
	}
	public void setSxTypeName(String sxTypeName) {
		this.sxTypeName = sxTypeName;
	}
	
}

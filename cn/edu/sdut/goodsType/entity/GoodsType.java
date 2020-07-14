package cn.edu.sdut.goodsType.entity;

import lombok.Data;

@Data
public class GoodsType {

	private Integer typeid;
	private String typename;
	
	@Override
	public String toString() {
		return typename;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	
}

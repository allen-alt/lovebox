package cn.model;

public class SxType {
	private int id;
	private String sxTypeName;
	private String sxTypeDesc;
	
	
	
	public SxType(String sxTypeName, String sxTypeDesc) {
		super();
		this.sxTypeName = sxTypeName;
		this.sxTypeDesc = sxTypeDesc;
	}
	public int getId() {
		return id;
	}
	public SxType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSxTypeName() {
		return sxTypeName;
	}
	public void setSxTypeName(String sxTypeName) {
		this.sxTypeName = sxTypeName;
	}
	public String getSxTypeDesc() {
		return sxTypeDesc;
	}
	public void setSxTypeDesc(String sxTypeDesc) {
		this.sxTypeDesc = sxTypeDesc;
	}
	
	

}

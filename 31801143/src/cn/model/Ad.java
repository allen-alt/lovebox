package cn.model;

public class Ad {
	public static User currentLoginUser=null;
	private int Ad_id;
	private String Ad_name;
	private String Ad_pwd;
	public static User getCurrentLoginUser() {
		return currentLoginUser;
	}
	public static void setCurrentLoginUser(User currentLoginUser) {
		Ad.currentLoginUser = currentLoginUser;
	}
	public int getAd_id() {
		return Ad_id;
	}
	public void setAd_id(int ad_id) {
		Ad_id = ad_id;
	}
	public String getAd_name() {
		return Ad_name;
	}
	public void setAd_name(String ad_name) {
		Ad_name = ad_name;
	}
	public String getAd_pwd() {
		return Ad_pwd;
	}
	public void setAd_pwd(String ad_pwd) {
		Ad_pwd = ad_pwd;
	}
	
	

}

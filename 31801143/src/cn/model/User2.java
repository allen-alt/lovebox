package cn.model;



public class User2 {
	public static User2 currentLoginUser=null;
	private int user_id;
	private String user_name;
	private String user_sex;
	private String user_pwd;
	private String user_phone;
	private String user_email;
	private String user_city;
	private java.util.Date user_regtime;
	private String user_ifvip;
	private java.util.Date user_vipenddate;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public static User2 getCurrentLoginUser() {
		return currentLoginUser;
	}
	public static void setCurrentLoginUser(User2 currentLoginUser) {
		User2.currentLoginUser = currentLoginUser;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_phone() {
		return user_phone;
	}
	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_city() {
		return user_city;
	}
	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}
	public java.util.Date getUser_regtime() {
		return user_regtime;
	}
	public void setUser_regtime(java.util.Date user_regtime) {
		this.user_regtime = user_regtime;
	}
	public String getUser_ifvip() {
		return user_ifvip;
	}
	public void setUser_ifvip(String user_ifvip) {
		this.user_ifvip = user_ifvip;
	}
	public java.util.Date getUser_vipenddate() {
		return user_vipenddate;
	}
	public void setUser_vipenddate(java.util.Date user_vipenddate) {
		this.user_vipenddate = user_vipenddate;
	}
	
}

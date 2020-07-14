package cn.edu.sdut.user.dao;

import cn.edu.sdut.user.entity.Tbuser;

public interface UserDao {
	//登录方法，只写声明部分;
	Tbuser login(Tbuser user);
	Tbuser selectUserById(Integer userid);	
	int updateUserInformation(Tbuser tbuser);
}

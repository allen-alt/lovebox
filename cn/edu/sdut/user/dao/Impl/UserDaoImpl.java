package cn.edu.sdut.user.dao.Impl;

import cn.edu.sdut.comm.base.dao.BaseDaoImpl;
import cn.edu.sdut.user.dao.UserDao;
import cn.edu.sdut.user.entity.Tbuser;

public class UserDaoImpl extends BaseDaoImpl<Tbuser> implements UserDao {

	@Override
	public Tbuser login(Tbuser user) {
		String sql = "SELECT * FROM tbuser WHERE username=? AND PASSWORD =?";
		//第一和参数：sql语句；
		//第二个参数：数据库的一条记录放在哪个实体类
		//第三个参数：给？赋值
		return super.selectOne(sql, Tbuser.class, user.getUsername(),user.getPassword());
	}

	@Override
	public Tbuser selectUserById(Integer userid) {
		String sql = "SELECT * FROM tbuser WHERE userid=?";
		return super.selectOne(sql, Tbuser.class, userid);
	}

	@Override
	public int updateUserInformation(Tbuser tbuser) {
		String sql = "UPDATE tbuser SET username=?,nickname=?,email=?,tel=?,address=? WHERE userid=?";
		return super.saveOrUpdate(sql, tbuser.getUsername(),tbuser.getNickname(),tbuser.getEmail(),tbuser.getTel(),tbuser.getAddress(),tbuser.getUserid());
	}
	
}

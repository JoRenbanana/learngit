package com.ssh.demo.dao;

import java.util.List;

import com.ssh.demo.bean.User;

public interface IuserDao {
	public boolean ckeckLogin(User u);

	public void addusers(User u);

	public List<User> getAlluser(int pageNo, int pageSize);

	public void deluser(User u);

	public void updateuser(User u);

	public List<User> querybymore(User u, int id2);

}

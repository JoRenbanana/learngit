package com.ssh.demo.service;

import java.util.List;

import com.ssh.demo.bean.User;

public interface IuserServise {

	public boolean getckeckLogin(User u);

	public void adduser(User u);

	public List<User> getAlluser(int pageNo, int pageSize);

	public void deluser(User u);

	public void updateuser(User u);

	public List<User> querybymore(User u, int id2);

}

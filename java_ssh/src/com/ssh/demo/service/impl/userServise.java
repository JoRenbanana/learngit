package com.ssh.demo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssh.demo.bean.User;
import com.ssh.demo.dao.IuserDao;
import com.ssh.demo.service.IuserServise;

@Service("userservice")
public class userServise implements IuserServise {
	@Resource(name = "idao")
	private IuserDao idao;

	public boolean getckeckLogin(User u) {
		return idao.ckeckLogin(u);
	}

	public IuserDao getIdao() {
		return idao;
	}

	public void setIdao(IuserDao idao) {
		this.idao = idao;
	}

	public void adduser(User u) {
		idao.addusers(u);
	}

	public List<User> getAlluser(int pageNo, int pageSize) {

		return idao.getAlluser(pageNo, pageSize);
	}

	public void deluser(User u) {

		idao.deluser(u);
	}

	public void updateuser(User u) {

		idao.updateuser(u);
	}

	public List<User> querybymore(User u, int id2) {

		return idao.querybymore(u, id2);

	}

}

package com.ssh.demo.action;

import javax.annotation.Resource;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.demo.bean.User;
import com.ssh.demo.service.IuserServise;

@Controller("useraction")
@Scope("prototype")
public class userAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	@Resource(name = "userservice")
	private IuserServise userservice;
	private String userName;
	private String password;
    private int pageNo = 1;// 起始页
	private int pageSize = 5;// 每页显示多条条记录
    private String ids;
    private int id;
    private int id2;
    private String msg;//提示信息
    private List<User> users;
    private List<User> usersquery;
    public IuserServise getLoginservice() {
		return userservice;
	}

	public void setLoginservice(IuserServise userservice) {
		this.userservice = userservice;
	}

	//登陆
	public String loginAction() {
		User u = new User();
		u.setUserName(userName);
		u.setPassword(password);
		boolean aa = userservice.getckeckLogin(u);
		if(aa){
		ActionContext.getContext().getSession().put("userName",userName);//保存好用户名
		return "suc";}
		msg="账号或密码有误";
		return "fail";}
	
	
	//注册
	
	
	
	
	public String registerUserAction() {
		User u = new User();
		u.setUserName(userName);
		u.setPassword(password);
        try{
			userservice.adduser(u);
			msg="注册成功,登陆试试看";
			return "suc";
		} catch (Exception e) {
			msg="注册失败,请联系管理员";
			return "fail";
		}
		
	}
	

	// 查询所有用户,并分页

	public String getAlluserAction(){this.users = userservice.getAlluser(pageNo, pageSize);return "suc";}

	//删除用户
	public String deluserAction() {
		User u = new User();
		u.setId(id);
		try {
			userservice.deluser(u);
			return "suc";
		} catch (Exception e) {
			return "fail";
		}

	}
    //修改用户信息
	public String updateuserAction() {
		User u = new User();
		u.setId(id);
		u.setUserName(userName);
		u.setPassword(password);
		try {
			userservice.updateuser(u);
			return "suc";
		} catch (Exception e) {
			return "fail";
		}

	}

	    //批量删除用户
        public String bathdeluserAction() {
		System.out.println("获取到前台的批量删除Id串是" + ids);
		String[] idstr = ids.split(",");// 这里需要了解。。。怎么把字符串转化为字符串数组
		try {
			for (int i = 0; i < idstr.length; i++) {// 遍历数组
				User u = new User();
				u.setId(Integer.parseInt(idstr[i]));
				userservice.deluser(u);
			}
			return "suc";
		} catch (Exception e) {
			return "fail";
		}
	}

	    //多条件组合查询
        public String querybymoreAction() {
		User u = new User();
		u.setId(id);
		u.setUserName(userName);
		u.setPassword(password);
		this.usersquery = userservice.querybymore(u, id2);
		this.users = userservice.getAlluser(pageNo, pageSize);
		return "suc";

	}

    //添加用户
	public String adduserAction() {
		User u = new User();
		u.setUserName(userName);
		u.setPassword(password);
        try{
			userservice.adduser(u);
			return "suc";
		} catch (Exception e) {
			return "fail";
		}

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public List<User> getUsersquery() {
		return usersquery;
	}

	public void setUsersquery(List<User> usersquery) {
		this.usersquery = usersquery;
	}

	public int getId2() {
		return id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public IuserServise getUserservice() {
		return userservice;
	}

	public void setUserservice(IuserServise userservice) {
		this.userservice = userservice;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


}
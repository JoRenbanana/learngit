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
    private int pageNo = 1;// ��ʼҳ
	private int pageSize = 5;// ÿҳ��ʾ��������¼
    private String ids;
    private int id;
    private int id2;
    private String msg;//��ʾ��Ϣ
    private List<User> users;
    private List<User> usersquery;
    public IuserServise getLoginservice() {
		return userservice;
	}

	public void setLoginservice(IuserServise userservice) {
		this.userservice = userservice;
	}

	//��½
	public String loginAction() {
		User u = new User();
		u.setUserName(userName);
		u.setPassword(password);
		boolean aa = userservice.getckeckLogin(u);
		if(aa){
		ActionContext.getContext().getSession().put("userName",userName);//������û���
		return "suc";}
		msg="�˺Ż���������";
		return "fail";}
	
	
	//ע��
	
	
	
	
	public String registerUserAction() {
		User u = new User();
		u.setUserName(userName);
		u.setPassword(password);
        try{
			userservice.adduser(u);
			msg="ע��ɹ�,��½���Կ�";
			return "suc";
		} catch (Exception e) {
			msg="ע��ʧ��,����ϵ����Ա";
			return "fail";
		}
		
	}
	

	// ��ѯ�����û�,����ҳ

	public String getAlluserAction(){this.users = userservice.getAlluser(pageNo, pageSize);return "suc";}

	//ɾ���û�
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
    //�޸��û���Ϣ
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

	    //����ɾ���û�
        public String bathdeluserAction() {
		System.out.println("��ȡ��ǰ̨������ɾ��Id����" + ids);
		String[] idstr = ids.split(",");// ������Ҫ�˽⡣������ô���ַ���ת��Ϊ�ַ�������
		try {
			for (int i = 0; i < idstr.length; i++) {// ��������
				User u = new User();
				u.setId(Integer.parseInt(idstr[i]));
				userservice.deluser(u);
			}
			return "suc";
		} catch (Exception e) {
			return "fail";
		}
	}

	    //��������ϲ�ѯ
        public String querybymoreAction() {
		User u = new User();
		u.setId(id);
		u.setUserName(userName);
		u.setPassword(password);
		this.usersquery = userservice.querybymore(u, id2);
		this.users = userservice.getAlluser(pageNo, pageSize);
		return "suc";

	}

    //����û�
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
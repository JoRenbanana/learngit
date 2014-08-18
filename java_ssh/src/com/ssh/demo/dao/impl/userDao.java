package com.ssh.demo.dao.impl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import com.opensymphony.xwork2.ActionContext;
import com.ssh.demo.bean.User;
import com.ssh.demo.dao.IuserDao;
import com.ssh.demo.util.Pagination;
@Service("idao")
public class userDao extends Pagination implements IuserDao {
	
	private HibernateTemplate hibernateTemplate;
    public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public boolean ckeckLogin(User u) {
		List<User> list = hibernateTemplate.find(
				"from us where userName=? and password=?", new String[] {
						u.getUserName(), u.getPassword() });
		if (list != null && list.size() > 0) {
			return true;
		}
		return false;
	}

	public void addusers(User u) {
		hibernateTemplate.save(u);
	}

	public List<User> getAlluser(int pageNo, int pageSize) {
		// 调用分页模板
		List<User> list = new ArrayList<User>();
		try{
            long CountRecords=getCountRecords("select count(*) from us");
			ActionContext.getContext().getSession().put("CountRecords",CountRecords);// 把总记录数存入session
			ActionContext.getContext().getSession().put("pages",(CountRecords + pageSize - 1) / pageSize);
			list = findByPageBean(pageNo, pageSize, "from us");
		} catch (Exception e) {
			//查询异常
			e.printStackTrace();
		}
		return list;
	}

	public void deluser(User u) {

		hibernateTemplate.delete(u);
	}

	public void updateuser(User u) {
		hibernateTemplate.update(u);

	}

	// 多条件查询
	public List<User> querybymore(User u, int id2) {

		String hql = "from us where 1=1";

		if (u.getId() != 0) {

			hql += " and id between '" + u.getId() + "' and '" + id2 + "'";
		}
		if (u.getUserName() != null && u.getUserName().length() > 0) {
			hql += " and userName like '%" + u.getUserName() + "%'";
		}
		if (u.getPassword() != null && u.getPassword().length() > 0) {
			hql += " and password='" + u.getPassword() + "'";
		}
		return hibernateTemplate.find(hql);
	}

}

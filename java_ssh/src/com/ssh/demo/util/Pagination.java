package com.ssh.demo.util;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class Pagination {
	/**
	 * * 使用hql 语句进行操作 * *
	 * 
	 * @param hql *
	 *            HSQL 查询语句 *
	 * @param offset *
	 *            开始取数据的下标 *
	 * @param length *
	 *            读取数据记录数 *
	 * @return List 结果集
	 */
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	protected List findByPageBean(final int pageNo, final int pageSize,
			final String hql) throws Exception {
		List list = null;
		try {
			list = this.getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							Query query = session.createQuery(hql);
							query.setFirstResult(pageNo * pageSize - pageSize);
							query.setMaxResults(pageSize);
							List list = query.list();
							return list;
						}
					});
		} catch (Exception e) {
			throw e;
		}
		return list;
	}

	//获取总记录数
	protected long getCountRecords(String hql) throws Exception {// 获取总记录数
		return ((Long) getHibernateTemplate().iterate(hql).next()).intValue();

	}
}
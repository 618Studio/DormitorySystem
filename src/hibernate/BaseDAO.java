package hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class BaseDAO<T> {
	
	//插入数据
	public void create(T object){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			
			session.beginTransaction();	//开启事务
			session.persist(object);	//将对象保存进数据库
			session.getTransaction().commit(); //提交事务
			
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	}
	
	//更新数据库
	public void update(T object){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	}
	
	//从数据库中删除
	public void delete(T object)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	}
	
	//根据id查找Entity　Beans
	public T find(Class<? extends T>clazz, Serializable id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			return (T) session.get(clazz,id); //根据id查询实体类对象
		}finally{
			session.getTransaction().commit();
			session.close();
		}
	}
	
	//查找多个Entity Bean
	public List<T> list(String hql)
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			return session.createQuery(hql).list();
		}finally{
			session.getTransaction().commit();
			session.close();
		}
	}
	
	public static void main(String[] args)
	{
		Query query;
	}
}

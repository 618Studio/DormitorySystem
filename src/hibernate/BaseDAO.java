package hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class BaseDAO<T> {
	
	//��������
	public void create(T object){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			
			session.beginTransaction();	//��������
			session.persist(object);	//�����󱣴�����ݿ�
			session.getTransaction().commit(); //�ύ����
			
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
	}
	
	//�������ݿ�
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
	
	//�����ݿ���ɾ��
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
	
	//����id����Entity��Beans
	public T find(Class<? extends T>clazz, Serializable id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			return (T) session.get(clazz,id); //����id��ѯʵ�������
		}finally{
			session.getTransaction().commit();
			session.close();
		}
	}
	
	//���Ҷ��Entity Bean
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

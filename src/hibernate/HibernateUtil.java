package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	 private static SessionFactory sessionFactory;
     
     /**
     * @return ��ȡ�Ự����
     */
	 static{
		try{
			Configuration cfg = new Configuration();
			cfg.configure();
			sessionFactory = cfg.buildSessionFactory();
		}catch(Throwable e)
		{
			e.printStackTrace();
			System.out.println("��֪��");
		}
		
	 }
      
     /**
     * @return ��ȡ�Ự����
     */
	 public static SessionFactory getSessionFactory() { 
	      return sessionFactory;
	  }


}

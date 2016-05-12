package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	 private static SessionFactory sessionFactory;
     
     /**
     * @return 获取会话工厂
     */
	 static{
		try{
			Configuration cfg = new Configuration();
			cfg.configure();
			sessionFactory = cfg.buildSessionFactory();
		}catch(Throwable e)
		{
			e.printStackTrace();
			System.out.println("不知道");
		}
		
	 }
      
     /**
     * @return 获取会话对象
     */
	 public static SessionFactory getSessionFactory() { 
	      return sessionFactory;
	  }


}

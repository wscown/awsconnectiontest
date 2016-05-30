


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	
	static{
		Configuration config = new Configuration().configure();
		serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		try{
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		}catch(Exception e){
			System.out.println("Initial sessionfactory creation failure: " + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}

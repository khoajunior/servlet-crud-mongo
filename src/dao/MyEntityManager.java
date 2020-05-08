package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyEntityManager {
	private static MyEntityManager instance = null;
	private EntityManager em;
	
	private MyEntityManager() {
		em = Persistence.createEntityManagerFactory("jsp-servlet-hibernate-mongodb-crud-exmaple")
				.createEntityManager();
	}
	
	public synchronized static MyEntityManager getInstance() {
		if(instance == null)
			instance = new MyEntityManager();
		return instance;
	}
	
	public EntityManager getEntityManager() {
		return em;
	}
}

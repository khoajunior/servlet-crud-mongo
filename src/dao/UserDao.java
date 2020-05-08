package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.User;

public class UserDao {
	private EntityManager em;

	public UserDao() {
		em = MyEntityManager.getInstance().getEntityManager();
	}
	
	public boolean addUser(User user) {
		boolean result = false;
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			em.persist(user);
			tr.commit();
			result = true;
		}catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return result;
	}
	
	public List<User> findAll(){
		List<User> list = new ArrayList<User>();
		String sqlQuery = "db.User.find({})";
		List<?> temp = em.createNativeQuery(sqlQuery, User.class).getResultList();
		temp.forEach(x->{
			list.add((User) x);
			
		});
		return list;
	}
}

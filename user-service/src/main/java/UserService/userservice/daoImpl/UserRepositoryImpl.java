package UserService.userservice.daoImpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import UserService.userservice.dao.UserRepository;
import UserService.userservice.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private EntityManager entityManager;

	
	@Override
	public void save(User user) {

		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(user);
	}
	
	@Override
	public User findById(int id) {
		
		Session session = entityManager.unwrap(Session.class);
		User user = session.get(User.class, id);
		return user;
	}
	
	@Override
	public void updateUser(User user, int id) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("update User set firstName=:fName,lastName=:lName,dateOfBirth=:dob,city=:c,"
				+ "mobileNumber=:mobNumber where userId=:theId");
		theQuery.setParameter("fName",user.getFirstName());
		theQuery.setParameter("lName",user.getLastName());
		theQuery.setParameter("dob",user.getDateOfBirth());
		theQuery.setParameter("c",user.getCity());
		theQuery.setParameter("mobNumber",user.getMobileNumber());
		theQuery.setParameter("theId",id);
		theQuery.executeUpdate();
	}
	
	@Override
	public void deleteById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Query theQuery = session.createQuery("delete from User where userId=:theId");
		theQuery.setParameter("theId",id);
		theQuery.executeUpdate();
	}

	@Override
	public List<User> getUsers() {
		
		Session session = entityManager.unwrap(Session.class);
		Query<User> userList = session.createQuery("from User",User.class);
		List<User> list = userList.getResultList();
		return list;
	}

	
	
	
	
}

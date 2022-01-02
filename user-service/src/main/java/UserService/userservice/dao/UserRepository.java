package UserService.userservice.dao;

import java.util.List;

import UserService.userservice.entity.User;

public interface UserRepository {

	User findById(int id);
	void deleteById(int id);
	List<User> getUsers();
	void save(User user);
	void updateUser(User user,int id);
	
}

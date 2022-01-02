package UserService.userservice.service;

import java.util.List;

import UserService.userservice.entity.User;

public interface UserService {

	User getUserById(int id);
	void deleteUserById(int id);
	List<User> getAllUsers();
	void saveUser(User user);
	void updateUser(User user,int id);
	
}

package UserService.userservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import UserService.userservice.dao.UserRepository;
import UserService.userservice.entity.User;
import UserService.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User getUserById(int id) {
		return userRepository.findById(id);
	}

	@Override
	@Transactional
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.getUsers();
	}

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	@Transactional
	public void updateUser(User user,int id) {

		userRepository.updateUser(user,id);
		
	}

}

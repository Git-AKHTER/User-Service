package UserService.userservice.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import UserService.userservice.entity.User;
import UserService.userservice.error.DataNotFoundException;
import UserService.userservice.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/{id}")
	User getUserById(@PathVariable int id)
	{
		if(userService.getUserById(id) == null)
		{
			throw new DataNotFoundException("User Not Found "+id);
		}
		return userService.getUserById(id);
	}
	
	@GetMapping("/allUser")
	List<User> getAlluser()
	{
		return userService.getAllUsers();
	}
	
	@PostMapping("/save")
	void saveUser(@RequestBody User user) throws Exception
	{
		String m=user.getMobileNumber();
		
		if(m.matches("^[0-9]*$") && m.length()==10)
		{
			userService.saveUser(user);
		}
		else
		{
			throw new Exception("Mobile Number Must be 10 digit Number");
		}
	}
	
	@DeleteMapping("/delete/{id}")
	void deleteUserById(@PathVariable int id) 
	{
		if(userService.getUserById(id)!= null)
		{
			userService.deleteUserById(id);
		}
		else
		{
			throw new DataNotFoundException("User Not Found "+id);
		}
		
		
	}
	
	@PutMapping("/update/{id}")
	void updateUser(@RequestBody User user,@PathVariable int id)
	{
		if(userService.getUserById(id) == null)
		{
			throw new DataNotFoundException("User Not Found "+id);
		}
		else 
		{
			user.setFirstName(user.getFirstName());
			user.setLastName(user.getLastName());
			user.setCity(user.getCity());
			user.setDateOfBirth(user.getDateOfBirth());
			user.setMobileNumber(user.getMobileNumber());
			userService.updateUser(user, id);
		}
	}
	
}

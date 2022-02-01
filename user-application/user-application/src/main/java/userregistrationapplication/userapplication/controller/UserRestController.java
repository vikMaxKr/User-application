package userregistrationapplication.userapplication.controller;

import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import userregistrationapplication.userapplication.entity.User;
import userregistrationapplication.userapplication.service.UserService;

@RestController
@RequestMapping("/rest")
public class UserRestController {
	
	
	private Logger logger = Logger.getLogger(getClass().getName());
	@Autowired
	private UserService userservice;
	
	public UserRestController(UserService userservice)
	{
		this.userservice=userservice;
	}
	
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userservice.findAll();
	}
	@PostMapping("/saveuser")
	public User addUser( @RequestBody User theUser )
	{
		List<User> user=getUsers();
		for (int i = 0; i < user.size(); i++) {
			if (theUser.getUserName().equals(user.get(i).getUserName())) {
				logger.info(" found "+user.get(i).getUserName());
				return null;
			}
		}
		userservice.save(theUser);
		return theUser;
		
	}
	@GetMapping("/users/{userName}")
	public User getUserByName(@PathVariable String userName)
	{
		User theuser=userservice.findById(userName);
		return theuser;
	}

}

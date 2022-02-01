package userregistrationapplication.userapplication.service;

import java.util.List;
import userregistrationapplication.userapplication.entity.User;

public interface UserService {
	
     public List<User> findAll();
	
	public User findById(String theUser);
	
	public void save(User theUser);
	

}

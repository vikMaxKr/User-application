package userregistrationapplication.userapplication.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userregistrationapplication.userapplication.dao.UserRepository;
import userregistrationapplication.userapplication.entity.User;

@Service
public class UserServiceImp implements UserService {

	private UserRepository userRepository;


	@Autowired
	public UserServiceImp(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {

		return userRepository.findAll();
	}

	@Override
	public void save(User theUser) {
		userRepository.save(theUser);
	}

	@Override
	public User findById(String theUser) {
		Optional<User> optional = userRepository.findById(theUser);

		User theuser = null;

		if (optional.isPresent()) {

			theuser = optional.get();
		} else {
			throw new RuntimeException("Did'nt find user " + theUser);
		}
		return theuser;
	}
}

package userregistrationapplication.userapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import userregistrationapplication.userapplication.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}

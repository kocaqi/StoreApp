package com.localweb.thelogin.thelogin.dao;

import com.localweb.thelogin.thelogin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findUserByEmail(String email);

	User findUserByFirstName(String name);

	User getUserById(int id);

}


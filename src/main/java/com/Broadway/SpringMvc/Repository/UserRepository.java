package com.Broadway.SpringMvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Broadway.SpringMvc.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByusernameAndPassword(String un, String psw);

}

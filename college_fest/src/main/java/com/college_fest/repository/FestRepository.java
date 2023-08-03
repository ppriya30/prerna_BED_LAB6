package com.college_fest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.college_fest.model.User;

@Repository
public interface FestRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.user_name = ?1")
	public User getUserByUsername(String username);

}

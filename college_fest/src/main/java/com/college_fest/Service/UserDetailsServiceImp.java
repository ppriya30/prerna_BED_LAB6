package com.college_fest.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.college_fest.Security.MyUserdetail;
import com.college_fest.model.User;
import com.college_fest.repository.FestRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	FestRepository festRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User users = festRepository.getUserByUsername(username);

		if (users == null) {
			throw new UsernameNotFoundException("could not find user");

		}

		return new MyUserdetail(users);
	}

}

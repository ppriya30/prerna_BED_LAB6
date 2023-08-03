package com.college_fest.Security;

import javax.sql.DataSource;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.college_fest.Service.UserDetailsServiceImp;
@Configuration
@EnableWebSecurity
public class Webconfig {
	
	public DaoAuthenticationProvider myauthenicationProvider() {
		
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(myUser());
		dao.setPasswordEncoder(myPassword());
		return dao;
	}

	@Bean
	public UserDetailsService myUser() {
		return (new UserDetailsServiceImp());
		
	}
	
	@Bean
	public BCryptPasswordEncoder myPassword() {
		
		return new BCryptPasswordEncoder() ;
	}
	
	/*@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("null");
	}*/
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/student/update" , "/student/delete").hasAuthority("ADMIN")
		.antMatchers("/student/save", "/student/new" , "/student/403").hasAnyAuthority("ADMIN","USER")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginProcessingUrl("/login").successForwardUrl("/student/list").permitAll()
		.and()
		.logout().logoutSuccessUrl("/login").permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/student/403")
		.and()
		.cors()
		.and()
		.csrf().disable();
		
		http.authenticationProvider(myauthenicationProvider());
		
		return http.build();
	}
	

	
	
	
	

}

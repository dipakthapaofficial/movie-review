package com.codeinteracts.moviereview;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	
	
	@Bean
	public SecurityFilterChain cofigureFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.authorizeHttpRequests()
		.requestMatchers("/web/movie/", "/web/user/").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
//		.httpBasic()
//		.loginPage("login/login.html");
		
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public UserDetailsService getUsers() {
		UserDetails user = User.withUsername("user").password(getPasswordEncoder().encode("user")).roles("USER").build();

		UserDetails admin = User.withUsername("admin").password(getPasswordEncoder().encode("admin")).roles("USER", "ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	

}

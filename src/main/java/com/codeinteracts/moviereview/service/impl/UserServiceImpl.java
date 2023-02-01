package com.codeinteracts.moviereview.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeinteracts.moviereview.dto.UserDTO;
import com.codeinteracts.moviereview.entity.User;
import com.codeinteracts.moviereview.exception.DuplicateUserNameException;
import com.codeinteracts.moviereview.repository.UserRepository;
import com.codeinteracts.moviereview.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User create(UserDTO userDTO) throws DuplicateUserNameException {
		//Check if username already exists
		User existingUser = get(userDTO.getUsername());
		
		if (existingUser != null ) {
			throw new DuplicateUserNameException("Username already exists");
		}
		
		User user = new User();
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setUsername(userDTO.getUsername());
		user.setActive(Boolean.TRUE);
		userRepository.save(user);
		return user;
	}

	@Override
	public List<User> list() {
		return userRepository.findAll();
	}

	@Override
	public User get(Long id) {
		return userRepository.findById(id).get();
	}
	
	@Override
	public User get(String username) {
//		return userRepository.findBy(null, null);
		return null;
	}


	@Override
	public User update(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword());
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setActive(Boolean.TRUE);
		userRepository.save(user);
		return user;
	}
	
	@Override
	public User delete(Long id) {
		User user = userRepository.findById(id).get();
		user.setActive(Boolean.FALSE);
		return user;
	}

}

package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import pl.coderslab.model.User;
import pl.coderslab.repository.UserRepository;

public class UserGroupConverter implements Converter<String, User> {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User convert(String source) {
	User user = userRepository.findOne(Long.parseLong(source));
	        return user;
	    }
}


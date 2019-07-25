/*package com.tuyano.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.tuyano.springboot.data.UserData;
import com.tuyano.springboot.repositories.UserDataRepository;

/*@Component
public class UserServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDataRepository userDataRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		if (StringUtils.isEmpty(username)) {
			throw new UsernameNotFoundException("");
		}
		
		UserData userdata = userDataRepository.findByUsername(username);
		if (userdata == null) {
			throw new UsernameNotFoundException("");
		}
		
		return username;
	}

}*/
package com.Digipaywallet.DigiPayWalletRevamp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Digipaywallet.DigiPayWalletRevamp.dao.SignUpRepository;
import com.Digipaywallet.DigiPayWalletRevamp.entity.GenUsers;
import com.Digipaywallet.DigiPayWalletRevamp.vo.UsersVO;


@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private SignUpRepository signUpRepository;
	

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		GenUsers genUsers = signUpRepository.findByPhone(Long.parseLong(username));
		if (genUsers == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(String.valueOf(genUsers.getPhone()), genUsers.getPassword(),
				new ArrayList<>());
	}
	
	public UsersVO loadUserId(String username) {
		UsersVO userVO = null;
		try {
			GenUsers genUsers = signUpRepository.findByPhone(Long.parseLong(username));
			if (genUsers != null) {
				userVO = new UsersVO();
				userVO.setUserId(String.valueOf(genUsers.getUsersId()));
			}
		}
		catch(Exception e) {
			
		}
		return userVO;
	}
	 
	
}

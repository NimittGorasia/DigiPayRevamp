package com.Digipaywallet.DigiPayWalletRevamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Digipaywallet.DigiPayWalletRevamp.dao.SignUpRepository;
import com.Digipaywallet.DigiPayWalletRevamp.entity.GenUsers;
import com.Digipaywallet.DigiPayWalletRevamp.vo.UsersVO;

@Service
public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	private SignUpRepository signUpRepository;

	@Override
	public boolean saveUserOnSignUp(UsersVO usersVO) throws Exception {
		GenUsers genUsers = new GenUsers();
		
		genUsers.setFirstName(usersVO.getFirstName());
		genUsers.setLastName(usersVO.getLastName());
		genUsers.setPhone(Long.parseLong(usersVO.getContact()));
		genUsers.setEmail(usersVO.getEmail());
		genUsers.setIsactive("Y");
		genUsers.setPassword(usersVO.getPassword());
		genUsers.setCreatedOn(new java.util.Date() );
		genUsers.setLastLogin(new java.util.Date());
		
		signUpRepository.save(genUsers);
		return true;
	}

}

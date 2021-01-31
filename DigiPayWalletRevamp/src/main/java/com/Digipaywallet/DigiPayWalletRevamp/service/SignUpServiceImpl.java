package com.Digipaywallet.DigiPayWalletRevamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.Digipaywallet.DigiPayWalletRevamp.dao.SignUpDao;
import com.Digipaywallet.DigiPayWalletRevamp.vo.UsersVO;

public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	@Qualifier("signUpDaoImpl")
	SignUpDao signUpDao;

	@Override
	public boolean saveUserOnSignUp(UsersVO usersVO) throws Exception {
		return signUpDao.saveUserOnSignUp(usersVO);
	}

}

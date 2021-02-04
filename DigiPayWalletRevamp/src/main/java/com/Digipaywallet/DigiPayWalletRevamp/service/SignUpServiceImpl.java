package com.Digipaywallet.DigiPayWalletRevamp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Digipaywallet.DigiPayWalletRevamp.dao.SignUpDao;
import com.Digipaywallet.DigiPayWalletRevamp.vo.UsersVO;

@Service
public class SignUpServiceImpl implements SignUpService {
	
	@Autowired
	@Qualifier("signUpDaoImpl")
	public SignUpDao signUpDao;

	@Override
	@Transactional
	public boolean saveUserOnSignUp(UsersVO usersVO) throws Exception {
		return signUpDao.saveUserOnSignUp(usersVO);
	}

}

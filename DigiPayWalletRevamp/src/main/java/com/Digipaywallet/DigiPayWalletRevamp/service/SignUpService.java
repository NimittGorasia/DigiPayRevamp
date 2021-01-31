package com.Digipaywallet.DigiPayWalletRevamp.service;

import com.Digipaywallet.DigiPayWalletRevamp.vo.UsersVO;

public interface SignUpService {

	public boolean saveUserOnSignUp(UsersVO usersVO) throws Exception;
	
}

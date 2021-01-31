package com.Digipaywallet.DigiPayWalletRevamp.dao;

import com.Digipaywallet.DigiPayWalletRevamp.vo.UsersVO;

public interface SignUpDao {
	public boolean saveUserOnSignUp(UsersVO usersVO) throws Exception;
}

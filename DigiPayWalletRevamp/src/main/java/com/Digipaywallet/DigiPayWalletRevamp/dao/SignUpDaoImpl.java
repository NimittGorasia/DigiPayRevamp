package com.Digipaywallet.DigiPayWalletRevamp.dao;

import com.Digipaywallet.DigiPayWalletRevamp.entity.GenUsers;
import com.Digipaywallet.DigiPayWalletRevamp.vo.UsersVO;

public class SignUpDaoImpl implements SignUpDao {

	@Override
	public boolean saveUserOnSignUp(UsersVO usersVO) throws Exception {
		GenUsers genUsers = null;
		try {
			//genUsers.setEmail();
			
			
		}
		catch(Exception e) {
			System.out.println("Exception :" +e);
		}
		
		return true;
	}

}

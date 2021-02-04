package com.Digipaywallet.DigiPayWalletRevamp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Digipaywallet.DigiPayWalletRevamp.entity.GenUsers;
import com.Digipaywallet.DigiPayWalletRevamp.vo.UsersVO;

@Repository
public class SignUpDaoImpl implements SignUpDao {
	
	
	 @Autowired 
	 SessionFactory sessionFactory;
	 
	
	@Override
	public boolean saveUserOnSignUp(UsersVO usersVO) throws Exception {
		GenUsers genUsers = null;
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			currentSession.beginTransaction();
			genUsers = new GenUsers();
			
			genUsers.setUserName(usersVO.getUserName());
			genUsers.setPhone(Long.parseLong(usersVO.getContact()));
			genUsers.setEmail(usersVO.getEmail());
			genUsers.setIsactive("Y");
			genUsers.setPassword(usersVO.getPassword());
			genUsers.setCreatedOn(new java.util.Date() );
			genUsers.setLastLogin(new java.util.Date());
			
			
			currentSession.saveOrUpdate(genUsers);
			
			currentSession.getTransaction().commit();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			sessionFactory.close();
		}
		
		return true;
	}

}

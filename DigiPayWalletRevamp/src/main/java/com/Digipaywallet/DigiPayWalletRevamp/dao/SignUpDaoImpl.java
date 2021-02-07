package com.Digipaywallet.DigiPayWalletRevamp.dao;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
			
			genUsers.setFirstName(usersVO.getFirstName());
			genUsers.setLastName(usersVO.getLastName());
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


	@Override
	@Transactional
	public UsersVO authenticateUser(String phone) {
	GenUsers genUsers = null;
	UsersVO usersVO = new UsersVO();
	try {
		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(GenUsers.class);
		criteria.add(Restrictions.eq("phone", Long.parseLong(phone)));
		genUsers = (GenUsers) criteria.uniqueResult();
		
		if(null != genUsers) {
			usersVO.setFirstName(genUsers.getFirstName());
			usersVO.setLastName(genUsers.getLastName());
			usersVO.setContact(String.valueOf(genUsers.getPhone()));
			usersVO.setEmail(genUsers.getEmail());
			usersVO.setPassword(genUsers.getPassword());
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return usersVO;
  }
}

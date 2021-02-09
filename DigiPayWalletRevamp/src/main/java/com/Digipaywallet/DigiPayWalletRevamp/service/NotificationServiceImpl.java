package com.Digipaywallet.DigiPayWalletRevamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Digipaywallet.DigiPayWalletRevamp.vo.MailVO;
import com.Digipaywallet.DigiPayWalletRevamp.vo.UsersVO;

@Service
public class NotificationServiceImpl implements NotificationService{

	private JavaMailSender javaMailSender;
	
	@Autowired
	public NotificationServiceImpl(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
	@Autowired
	private Environment env;

	@Override
	public void sendNotification(UsersVO userVO,MailVO mailVO) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(userVO.getEmail());
		mail.setFrom(env.getProperty("spring.mail.username"));
		mail.setSubject(mailVO.getSubject());
		mail.setText(mailVO.getMessage());
		
		
		javaMailSender.send(mail);
	}
}

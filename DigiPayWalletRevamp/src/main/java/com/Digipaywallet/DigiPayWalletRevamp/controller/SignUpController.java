package com.Digipaywallet.DigiPayWalletRevamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Digipaywallet.DigiPayWalletRevamp.service.NotificationService;
import com.Digipaywallet.DigiPayWalletRevamp.service.SignUpService;
import com.Digipaywallet.DigiPayWalletRevamp.vo.MailVO;
import com.Digipaywallet.DigiPayWalletRevamp.vo.UsersVO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/signUp")
public class SignUpController {
	
	@Autowired
	@Qualifier("signUpServiceImpl")
	public SignUpService signUpService;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	public NotificationService notificationService;

	@PostMapping("/register")
	public  ResponseEntity<?> register(@RequestBody UsersVO usersVO) {
		MailVO mailVO = new MailVO();
		try {
			
			if(null != usersVO) {
				usersVO.setPassword(passwordEncoder.encode(usersVO.getPassword()));
				signUpService.saveUserOnSignUp(usersVO);
				
				mailVO.setSubject("Yay! You have successfully signed in");

				mailVO.setMessage("Dear "+usersVO.getFirstName()+",\n\n We are glad to have you on-board. We will have a great journey together. \n\n Team Digipay");
				
				notificationService.sendNotification(usersVO,mailVO );
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(usersVO);
	}
}

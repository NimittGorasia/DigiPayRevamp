package com.Digipaywallet.DigiPayWalletRevamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Digipaywallet.DigiPayWalletRevamp.service.SignUpService;
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

	@PostMapping("/demoDetails")
	public UsersVO demoDetails(@RequestBody UsersVO usersVO) {
		try {
		String status = null;
		String message = null;
		if(null != usersVO) {
			
			usersVO.setPassword(passwordEncoder.encode(usersVO.getPassword()));
			
			signUpService.saveUserOnSignUp(usersVO);
			
			status = "200";
			message = "Success";
			usersVO.setStatusCode(status);
			usersVO.setMessage(message);
		}
		else {
			usersVO = new UsersVO();
			status = "404";
			message = "Resource not found";
			usersVO.setStatusCode(status);
			usersVO.setMessage(message);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersVO;
	}
	
	@PostMapping("/main")
	public UsersVO demo(@RequestBody UsersVO usersVO) {
		String result = "Welcome";
		String status = null;
		String message = null;
		if(null != usersVO) {
			status = "200";
			message = result+ usersVO.getUserName() + "Password:" + usersVO.getPassword() + "Email : "+usersVO.getEmail() 
			+ "Phone : " +usersVO.getContact();
			usersVO.setStatusCode(status);
			usersVO.setMessage(message);
		}
		
		return usersVO;
	}
	
}

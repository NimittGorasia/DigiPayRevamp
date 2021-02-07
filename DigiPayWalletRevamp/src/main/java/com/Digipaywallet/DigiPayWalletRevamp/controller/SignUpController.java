package com.Digipaywallet.DigiPayWalletRevamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
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

	@PostMapping("/register")
	public  ResponseEntity<?> register(@RequestBody UsersVO usersVO) {
		try {
			
			if(null != usersVO) {
				usersVO.setPassword(passwordEncoder.encode(usersVO.getPassword()));
				signUpService.saveUserOnSignUp(usersVO);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(usersVO);
	}
}

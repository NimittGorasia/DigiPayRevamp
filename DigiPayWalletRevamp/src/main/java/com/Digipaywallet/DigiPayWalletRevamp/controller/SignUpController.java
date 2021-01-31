package com.Digipaywallet.DigiPayWalletRevamp.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Digipaywallet.DigiPayWalletRevamp.entity.GenUsers;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/signUp")
public class SignUpController {

	@PostMapping("/demoDetails")
	public GenUsers demoDetails(@RequestBody GenUsers genUsers) {
		GenUsers res = new GenUsers();
		System.out.println(genUsers.getFirstName());
		String result = "Welcome";
		if(null != genUsers) {
			result = result+genUsers.getFirstName();
			res.setFirstName("Welcome "+genUsers.getFirstName());
		}
		return res;
	}
	
}

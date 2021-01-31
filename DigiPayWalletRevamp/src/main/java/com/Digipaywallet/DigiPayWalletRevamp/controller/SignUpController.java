package com.Digipaywallet.DigiPayWalletRevamp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Digipaywallet.DigiPayWalletRevamp.entity.GenUsers;

@RestController
@RequestMapping("/signUp")
public class SignUpController {
	
	@GetMapping("/demoDetailsShow")
	@ResponseBody
	public String demoDetailsShow(){
		return "welcome";
	}

	@PostMapping("/demoDetails")
	public String demoDetails(@RequestBody GenUsers genUsers) {
		String result = "Welcome";
		if(null != genUsers) {
			result = result+genUsers.getFirstName();
		}
		return result;
	}
	
}

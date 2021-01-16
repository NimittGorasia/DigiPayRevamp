package com.Digipaywallet.DigiPayWalletRevamp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignUpController {

	
	@GetMapping("/load")
	@ResponseBody
	public String loadPage() {
		return "Welcome";
	}
	
}

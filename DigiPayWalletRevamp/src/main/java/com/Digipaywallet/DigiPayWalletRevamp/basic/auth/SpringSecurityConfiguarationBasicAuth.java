package com.Digipaywallet.DigiPayWalletRevamp.basic.auth;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


public class SpringSecurityConfiguarationBasicAuth extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
        .anyRequest()
        .permitAll();
	}
}

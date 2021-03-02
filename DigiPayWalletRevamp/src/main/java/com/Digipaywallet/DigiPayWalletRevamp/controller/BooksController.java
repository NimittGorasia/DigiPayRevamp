package com.Digipaywallet.DigiPayWalletRevamp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Digipaywallet.DigiPayWalletRevamp.service.BooksService;
import com.Digipaywallet.DigiPayWalletRevamp.vo.BooksVO;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	@PostMapping("/addBooks")
	public  ResponseEntity<?> addBook(@RequestBody BooksVO booksVO) {
		
		try {
			
			if(null != booksVO) {
				booksService.addBooks(booksVO);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok(booksVO);
	}


}

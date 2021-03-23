package com.Digipaywallet.DigiPayWalletRevamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Digipaywallet.DigiPayWalletRevamp.dao.BooksRepository;
import com.Digipaywallet.DigiPayWalletRevamp.entity.BookDetail;
import com.Digipaywallet.DigiPayWalletRevamp.vo.BooksVO;

@Service
public class BookServiceImpl implements BooksService {

	@Autowired
	private BooksRepository bookRepository;
	@Override
	public boolean addBooks(BooksVO booksVO) throws Exception {
		
		BookDetail bookDetail = new BookDetail();
		bookDetail.setAuthor(booksVO.getAuthor());
		bookDetail.setTitle(booksVO.getTitle());
		bookDetail.setDescription(booksVO.getDescription());
		bookDetail.setImage(booksVO.getImage());
		bookDetail.setGenre(booksVO.getGenre());
		bookDetail.setPrice(Double.parseDouble(booksVO.getPrice()));
		bookDetail.setCreatedOn(new java.util.Date() );
		
		bookRepository.save(bookDetail);
		return true;
	}

}

package com.sid.project.libMgmtSystem.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sid.project.libMgmtSystem.model.BooksDTO;
import com.sid.project.libMgmtSystem.spring.repository.BooksRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BooksRepository booksrepository;

	public void addbook(BooksDTO book) {
		booksrepository.insertBookToDB(book);
	}
	
	public List<BooksDTO> findAllBooks() {
		return booksrepository.getAllBooks();
	}
	
	public List<BooksDTO> findBooksByName(String bookName) {
		return booksrepository.getBooksByName(bookName);
	}

}

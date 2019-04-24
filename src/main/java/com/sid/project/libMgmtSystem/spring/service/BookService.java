package com.sid.project.libMgmtSystem.spring.service;

import java.util.List;

import com.sid.project.libMgmtSystem.model.BooksDTO;

public interface BookService {

	public void addbook(BooksDTO book);

	public List<BooksDTO> findAllBooks();

	public List<BooksDTO> findBooksByName(String bookName);
	
}

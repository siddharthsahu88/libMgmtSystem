package com.sid.project.libMgmtSystem.spring.repository;

import java.util.List;

import com.sid.project.libMgmtSystem.model.BooksDTO;

public interface BooksRepository {
	
	public void insertBookToDB(BooksDTO book);

	public List<BooksDTO> getAllBooks();

	public List<BooksDTO> getBooksByName(String bookName);

}

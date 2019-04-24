package com.sid.project.libMgmtSystem.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sid.project.libMgmtSystem.model.BooksDTO;
import com.sid.project.libMgmtSystem.spring.service.BookService;

@RestController
@RequestMapping("/lms/books")
public class BookController {

	private Logger log = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookservice;

	@PostMapping(value = "/add")
	public ResponseEntity<?> addBook(@RequestBody BooksDTO book) {

		try {
			// @Interceptors to validate users
			bookservice.addbook(book);

			log.info("Added new book: " + book.toString());

			return ResponseEntity.ok("New book added!");
		} catch (Exception e) {
			log.error(e.getMessage());

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Book failed to add!");
		}
	}

	@GetMapping(value = "/get/all")
	public List<BooksDTO> findAllBooks() {
		return bookservice.findAllBooks();
	}

	@GetMapping(value = "/get/book")
	public List<BooksDTO> findBooksByName(@RequestParam(value = "bookname") String bookName) {
		return bookservice.findBooksByName(bookName);
	}
}

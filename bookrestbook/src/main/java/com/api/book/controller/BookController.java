package com.api.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.entities.Books;
import com.api.book.service.BookSerivce;

@RestController
public class BookController {

	@Autowired
	public BookSerivce bookservice;

	@GetMapping("/books")
	public List<Books> getbooks() {

//		Books book=new Books();
//		book.setId(1045);
//		book.setTitle("Javadeveloper");
//		book.setAuthor("deepak behera");

		return this.bookservice.getAllBooks();

	}

	@GetMapping("/books/{id}")
	public Books getBook(@PathVariable int id) {
		return bookservice.getBookById(id);

	}

	@PostMapping("/books")
	public Books addBook(@RequestBody Books book) {
		Books b = this.bookservice.addBook(book);
		System.out.println(book);
		return b;

	}

	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
		this.bookservice.deleteBook(bookId);
	}

	@PutMapping("/books/{bookId}")
	public Books putBook(@RequestBody Books book, @PathVariable("bookId") int bookId) {
		this.bookservice.putBook(book, bookId);
		return book;
	}
}

package com.api.book.controller;

import java.awt.print.Book;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
//		book.setId(10);
//		book.setTitle("Java");
//		book.setAuthor("deepak");

		return this.bookservice.getAllBooks();

	}
	
	@GetMapping("/books/{id}")
	public Books getBook(@PathVariable("id")int id) {
		return bookservice.getBookById(id);
		
	}
	
	@GetMapping("/books/{title}")
	 public List<Books> findonebytitle(@PathVariable("title") String title)
	 {
		return (List<Books>) bookservice.findbyname(title);
		
	 }
	
	@PostMapping("/books")
	public Books addBook(@RequestBody Books book) {
		Books b = this.bookservice.addBook(book);
		System.out.println(book);
		return b;
	
	
}
}

package com.api.book.service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.el.stream.Optional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.api.book.entities.Books;

@Component
public class BookSerivce {

	private List<Books> list1 = new ArrayList<>();

	{

		list1.add(new Books(10, "java", "deepak"));
		list1.add(new Books(12, "python", "sagar"));
		list1.add(new Books(13, "angular", "bhavesh"));
	}

	// get all books
	public List<Books> getAllBooks() {
		return list1;

	}

	// get books by id
	public Books getBookById(int id) {
		Books book = null;
		book = list1.stream().filter(e -> e.getId() == id).findFirst().get();

		return book;

	}

	public List<Books> findbyname(String title) {
		// TODO Auto-generated method stub
		List b;
		b = list1.stream().filter(e -> e.getTitle() == title).collect(Collectors.toList());
		return b;
	}

	public Books addBook(Books b) {
		list1.add(b);
		return b;
	}
	
	
		
	

	 //get books by name
//	public Books getBookByTitle(String title)
//	{
//		Books name=null;
//	
//		name= list1.stream().filter(l->l.getTitle()==title).findFirst().get();
//		 return name;
//	}
}

package com.api.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.entities.Books;
import com.api.book.repository.BookRepository;

@Component
public class BookSerivce {
	
	@Autowired
	private BookRepository bookrepository;

//	private List<Books> list1 = new ArrayList<>();
//
//	{
//
//		list1.add(new Books(10, "java", "deepak"));
//		list1.add(new Books(12, "python", "sagar"));
//		list1.add(new Books(13, "angular", "bhavesh"));
//	}

	// get all books
	public List<Books> getAllBooks() {
		List<Books>list1=this.bookrepository.findAll();
		return list1;

	}

	// get books by id
	public Books getBookById(int id) {
		Books book = null;
	//	book = list1.stream().filter(e -> e.getId() == id).findFirst().get();
		book=this.bookrepository.findById(id);
		return book;
	}



	// adding the book
	public Books addBook(Books b) {
		//list1.add(b);
		Books result=bookrepository.save(b);
		return result;
	}

	// delete the book
	public void deleteBook(int bookId) {

	//	list1 = list1.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList());
		
		bookrepository.deleteById(bookId);
	}

	// update the book
	public void putBook(Books book, int bookId) {
//		list1 = list1.stream().map(b -> {
//
//			if (b.getId() == bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(bookId);
		bookrepository.save(book);

	}

	// get books by name
//	public Books getBookByTitle(String title) {
//		Books name = null;
//
//		name = list1.stream().filter(l -> l.getTitle() == title).findFirst().get();
//		return name;
//	}

	
}

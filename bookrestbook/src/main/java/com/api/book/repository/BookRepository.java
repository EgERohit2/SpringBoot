package com.api.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.book.entities.Books;

public interface BookRepository extends JpaRepository<Books, Integer> {

	public Books findById(int id);
}

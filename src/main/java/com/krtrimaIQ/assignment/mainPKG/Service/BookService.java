package com.krtrimaIQ.assignment.mainPKG.Service;

import java.util.List;

import com.krtrimaIQ.assignment.mainPKG.Model.Book;

public interface BookService {
	 Book createBook(Book book);
	    Book getBookById(Long id);
	    Book updateBook(Long id, Book book);
	    void deleteBook(Long id);
	    List<Book> listAllBooks();
	
}

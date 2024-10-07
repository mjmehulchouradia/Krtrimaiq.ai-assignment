package com.krtrimaIQ.assignment.mainPKG.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krtrimaIQ.assignment.mainPKG.Exception.ResourceNotFoundException;
import com.krtrimaIQ.assignment.mainPKG.Model.Author;
import com.krtrimaIQ.assignment.mainPKG.Model.Book;
import com.krtrimaIQ.assignment.mainPKG.Repository.AuthorRepository;
import com.krtrimaIQ.assignment.mainPKG.Repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Book createBook(Book book) {
        // Optionally check if the author exists before creating a book
        if (book.getAuthor() != null && book.getAuthor().getId() != null) {
            Author author = authorRepository.findById(book.getAuthor().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + book.getAuthor().getId()));
            book.setAuthor(author);
        }
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    @Override
    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));

        // Update fields of the existing book
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setIsbn(updatedBook.getIsbn());
        existingBook.setPublishedDate(updatedBook.getPublishedDate());
        
        if (updatedBook.getAuthor() != null && updatedBook.getAuthor().getId() != null) {
            Author author = authorRepository.findById(updatedBook.getAuthor().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id: " + updatedBook.getAuthor().getId()));
            existingBook.setAuthor(author);
        }

        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        bookRepository.delete(book);
    }

    @Override
    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }
}


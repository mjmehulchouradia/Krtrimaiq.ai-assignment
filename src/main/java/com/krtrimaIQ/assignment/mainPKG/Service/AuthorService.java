package com.krtrimaIQ.assignment.mainPKG.Service;

import java.util.List;

import com.krtrimaIQ.assignment.mainPKG.Model.Author;

public interface AuthorService {
    Author createAuthor(Author author);
    Author getAuthorById(Long id);
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);
    List<Author> listAllAuthors();
}
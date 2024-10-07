package com.krtrimaIQ.assignment.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.krtrimaIQ.assignment.mainPKG.Exception.ResourceNotFoundException;
import com.krtrimaIQ.assignment.mainPKG.Model.Book;
import com.krtrimaIQ.assignment.mainPKG.Repository.BookRepository;
import com.krtrimaIQ.assignment.mainPKG.Service.BookServiceImpl;

@ExtendWith(MockitoExtension.class)
public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    public void testGetBookById_Success() {
        // Arrange
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        // Act
        Book result = bookService.getBookById(1L);

        // Assert
        assertNotNull(result);
        assertEquals("Test Book", result.getTitle());
    }

    @Test
    public void testGetBookById_NotFound() {
    	
        when(bookRepository.findById(1L)).thenReturn(Optional.empty());

        ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
            bookService.getBookById(1L);
        });
        assertEquals("Book not found with id: 1", exception.getMessage());
    }
}

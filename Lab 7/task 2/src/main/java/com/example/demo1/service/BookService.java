package com.example.demo1.service;

import com.example.demo1.entity.Book;
import com.example.demo1.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByPrice(double amount) {
        return bookRepository.findBooksByPriceGreaterThan(amount);
    }

    @Transactional
    public int updateBookPrice(Long id, double newPrice) {
        return bookRepository.updateBookPrice(id, newPrice);
    }

    @Transactional
    public int deleteBookIfOutOfStock(Long id) {
        return bookRepository.deleteBookIfOutOfStock(id);
    }

    public List<Book> searchBooksByTitle(String title) {
        return bookRepository.findBooksByTitle(title);
    }
}

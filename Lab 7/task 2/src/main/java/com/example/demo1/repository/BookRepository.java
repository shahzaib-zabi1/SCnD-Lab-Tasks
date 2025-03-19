package com.example.demo1.repository;

import com.example.demo1.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Get books priced above a specific amount
    @Query("SELECT b FROM Book b WHERE b.price > :amount")
    List<Book> findBooksByPriceGreaterThan(double amount);

    // Update book price by ID
    @Modifying
    @Transactional
    @Query("UPDATE Book b SET b.price = :newPrice WHERE b.id = :id")
    int updateBookPrice(Long id, double newPrice);

    // Delete book if it’s out of stock
    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.id = :id AND b.inStock = false")
    int deleteBookIfOutOfStock(Long id);

    // Find books by title (case-insensitive)
    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Book> findBooksByTitle(String title);
}

package com.example.demo1.controller;

import com.example.demo1.entity.Book;
import com.example.demo1.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Get books priced above a specific amount
    @GetMapping("/price/{amount}")
    public ResponseEntity<List<Book>> getBooksByPrice(@PathVariable double amount) {
        return ResponseEntity.ok(bookService.getBooksByPrice(amount));
    }

    // Update book price by ID
    @PutMapping("/{id}/price/{newPrice}")
    public ResponseEntity<String> updateBookPrice(@PathVariable Long id, @PathVariable double newPrice) {
        int updated = bookService.updateBookPrice(id, newPrice);
        return updated > 0 ? ResponseEntity.ok("Book price updated") : ResponseEntity.badRequest().body("Book not found");
    }

    // Delete book if out of stock
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        int deleted = bookService.deleteBookIfOutOfStock(id);
        return deleted > 0 ? ResponseEntity.ok("Book deleted") : ResponseEntity.badRequest().body("Book not found or in stock");
    }

    // Search books by title (case-insensitive)
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String title) {
        return ResponseEntity.ok(bookService.searchBooksByTitle(title));
    }
}

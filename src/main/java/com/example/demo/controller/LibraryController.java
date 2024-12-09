package com.example.demo.controller;

import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Librarian;
import com.example.demo.entity.Library;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.LibrarianService;
import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private LibrarianService librarianService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    // Library Endpoints
    @PostMapping("/libraries")
    public Library createLibrary(@RequestBody Library library) {
        return libraryService.createLibrary(library);
    }

    @GetMapping("/libraries")
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    // Librarian Endpoints
    @PostMapping("/libraries/{libraryId}/librarian")
    public Librarian assignLibrarian(@PathVariable Long libraryId, @RequestBody Librarian librarian) {
        return librarianService.assignLibrarianToLibrary(libraryId, librarian);
    }

    // Book Endpoints
    @PostMapping("/libraries/{libraryId}/books")
    public Book addBook(@PathVariable Long libraryId, @RequestBody Book book) {
        return bookService.addBookToLibrary(libraryId, book);
    }

    // Author Endpoints
    @PostMapping("/books/{bookId}/authors")
    public Author addAuthorToBook(@PathVariable Long bookId, @RequestBody Author author) {
        return authorService.addAuthorToBook(bookId, author);
    }
}

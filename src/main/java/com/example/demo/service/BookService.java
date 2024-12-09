package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Library;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryService libraryService;

    public Book addBookToLibrary(Long libraryId, Book book) {
        Library library = libraryService.findLibraryById(libraryId);
        book.setLibrary(library);
        return bookRepository.save(book);
    }
}

package com.example.demo;

import com.example.demo.controller.LibraryController;
import com.example.demo.entity.Author;
import com.example.demo.entity.Book;
import com.example.demo.entity.Librarian;
import com.example.demo.entity.Library;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
    @Autowired
    private LibraryController libraryController;

    @Autowired
    private LibrarianService librarianService;

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello World");
        // 1. Create Library
        System.out.println("Creating Library...");
        Library library = new Library();
        library.setName("Central Library");
        library = libraryController.createLibrary(library);
        System.out.println("Created Library: " + library);

        // 2. Assign Librarian to Library
        System.out.println("Assigning Librarian...");
        Librarian librarian = new Librarian();
        librarian.setName("John Doe");
        librarian.setEmail("john.doe@example.com");
        librarian = libraryController.assignLibrarian(library.getId(), librarian);
        System.out.println("Assigned Librarian: " + librarian);

        // 3. Add Books to Library
        System.out.println("Adding Books to Library...");
        Book book1 = new Book();
        book1.setTitle("Effective Java");
        book1.setIsbn("978-0134685991");
        Book book2 = new Book();
        book2.setTitle("Clean Code");
        book2.setIsbn("978-0132350884");

        book1 = libraryController.addBook(library.getId(), book1);
        book2 = libraryController.addBook(library.getId(), book2);
        System.out.println("Added Books: " + book1 + ", " + book2);

        // 4. Add Authors to Books
        System.out.println("Adding Authors to Books...");
        Author author1 = new Author();
        author1.setName("Joshua Bloch");
        author1.setEmail("joshua.bloch@example.com");

        Author author2 = new Author();
        author2.setName("Robert C. Martin");
        author2.setEmail("robert.martin@example.com");

        author1 = libraryController.addAuthorToBook(book1.getId(), author1);
        author2 = libraryController.addAuthorToBook(book2.getId(), author2);
//        System.out.println("Added Authors: " + author1 + ", " + author2);

        // 5. Retrieve all Libraries
//        System.out.println("Retrieving all Libraries...");
//        List<Library> libraries = libraryController.getAllLibraries();
//        libraries.forEach(System.out::println);
    }
}

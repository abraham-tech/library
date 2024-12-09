package com.example.demo.service;

import com.example.demo.entity.Librarian;
import com.example.demo.entity.Library;
import com.example.demo.repository.LibrarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibrarianService {

    @Autowired
    private LibrarianRepository librarianRepository;

    @Autowired
    private LibraryService libraryService;

    public Librarian assignLibrarianToLibrary(Long libraryId, Librarian librarian) {
        Library library = libraryService.findLibraryById(libraryId);
        librarian.setLibrary(library);
        return librarianRepository.save(librarian);
    }
}

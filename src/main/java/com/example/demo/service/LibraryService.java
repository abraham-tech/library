package com.example.demo.service;

import com.example.demo.entity.Library;
import com.example.demo.repository.LibraryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    @Transactional
    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

    public Library findLibraryById(Long id) {
        return libraryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Library not found"));
    }
}

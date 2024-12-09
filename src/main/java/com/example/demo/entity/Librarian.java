package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "librarians")
@Data
@Getter
@Setter
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public void setLibrary(Library library) {
        this.library = library;
    }

    @OneToOne
    @JoinColumn(name="library_id", unique = true)
    private Library library;

}

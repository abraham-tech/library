package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "libraries")
@Data
@Getter
@Setter
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    @OneToOne(mappedBy = "library", cascade = CascadeType.ALL)
    private Librarian librarian;

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name +
                '}';
    }

}

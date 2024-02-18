package org.example.library.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;


import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String biography;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonManagedReference // Add this annotation to break the loop
    private List<Book> books;
}


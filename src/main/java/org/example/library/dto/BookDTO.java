package org.example.library.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long id;
    private String title;
    private String ISBN;
    private Long authorId;
}


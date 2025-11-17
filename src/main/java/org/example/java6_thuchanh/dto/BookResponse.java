package org.example.java6_thuchanh.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookResponse {

    private Long id;
    private String title;
    private String author;
    private double price;
    private String isbn;
}

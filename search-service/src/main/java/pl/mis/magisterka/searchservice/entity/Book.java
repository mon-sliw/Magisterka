package pl.mis.magisterka.searchservice.entity;

import lombok.Data;

@Data
public class Book {

    private Long id;

    private String title;

    private String author;

    private String kind;

    private String epoch;

    private String genre;

    private Integer rating;
}

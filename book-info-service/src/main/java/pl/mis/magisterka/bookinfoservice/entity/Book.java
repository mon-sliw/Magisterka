package pl.mis.magisterka.bookinfoservice.entity;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Book {

    @Id
    private Integer id;
    private String title;
    private String author;
    private String publisher;
    private String year;
    private String description;

}

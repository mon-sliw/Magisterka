package pl.mis.magisterka.bookinfoservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String author;

    private String kind;

    private String epoch;

    private String genre;

    public void copy( Book otherBook) {
        setTitle(otherBook.getTitle());
        setAuthor(otherBook.getAuthor());
        setKind(otherBook.getKind());
        setEpoch(otherBook.getEpoch());
        setGenre(otherBook.getGenre());
    }
}

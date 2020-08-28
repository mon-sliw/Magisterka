package pl.mis.magisterka.bookcatalogservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class BookCatalog {

    User user;

    List<Book> books;

}

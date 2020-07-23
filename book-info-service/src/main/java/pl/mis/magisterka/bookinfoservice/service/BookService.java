package pl.mis.magisterka.bookinfoservice.service;

import pl.mis.magisterka.bookinfoservice.entity.Book;

import java.util.Optional;

public interface BookService {

    public Optional<Book> getBookById(Integer bookId);
}

package pl.mis.magisterka.bookinfoservice.service;

import pl.mis.magisterka.bookinfoservice.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    Optional<Book> getBookById(Long bookId);

    List<Book> getAllBooks();

    List<Book> getBookBySearchString(String searchString);

    Book addBook(Book book);

    boolean deleteBook(Long bookId);

    Book editBook(Long bookId, Book newBook);

    void initDB();
}

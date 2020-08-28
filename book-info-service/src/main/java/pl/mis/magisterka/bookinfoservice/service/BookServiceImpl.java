package pl.mis.magisterka.bookinfoservice.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mis.magisterka.bookinfoservice.entity.Book;
import pl.mis.magisterka.bookinfoservice.repository.BookRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    RestTemplate restTemplate;

    @Override
    public Optional<Book> getBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> allBooks = new ArrayList<>();
        bookRepository.findAll().forEach(allBooks::add);
        return allBooks;
    }

    @Override
    public List<Book> getBookBySearchString(String searchString) {
        String sanitisedSearch = searchString.chars()
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return bookRepository.findAllByTitleContainingOrAuthorContaining(sanitisedSearch, sanitisedSearch);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean deleteBook(Long bookId) {
        if (bookRepository.existsById(bookId)) {
            bookRepository.deleteById(bookId);
            return true;
        }
        return false;
    }

    @Override
    public Book editBook(Long bookId, Book newBook) {
        if (bookRepository.existsById(bookId)) {
            newBook.setId(bookId);
            return bookRepository.save(newBook);
        }
        return null;
    }

    @Override
    public void initDB() {
        ResponseEntity<Book[]> response = restTemplate.getForEntity("https://wolnelektury.pl/api/books/", Book[].class);
        Book[] books = response.getBody();
        bookRepository.saveAll(Arrays.asList(books));
    }
}

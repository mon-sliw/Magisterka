package pl.mis.magisterka.bookinfoservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mis.magisterka.bookinfoservice.entity.Book;
import pl.mis.magisterka.bookinfoservice.repository.BookRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    @Override
    public Optional<Book> getBookById(Integer bookId) {
        return bookRepository.findById(bookId);
    }
}

package pl.mis.magisterka.bookinfoservice.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mis.magisterka.bookinfoservice.entity.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    public List<Book> findAllByTitleContainingOrAuthorContaining(String title, String author);
}

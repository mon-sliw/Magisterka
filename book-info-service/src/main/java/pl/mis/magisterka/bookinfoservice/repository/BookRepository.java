package pl.mis.magisterka.bookinfoservice.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mis.magisterka.bookinfoservice.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
}

package pl.mis.magisterka.bookinfoservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mis.magisterka.bookinfoservice.entity.Book;
import pl.mis.magisterka.bookinfoservice.service.BookService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/book")
public class BookInfoController {

    BookService bookService;

    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId) {
        return bookService.getBookById(bookId).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping("/search")
    public ResponseEntity<?> getBookBySearchString(@RequestBody String searchString) {
        List<Book> booksList = bookService.getBookBySearchString(searchString);
        if (booksList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(booksList);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        Book addedBook = bookService.addBook(book);
        if (addedBook == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.ok(addedBook);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        if (bookService.deleteBook(bookId))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<?> editBook(@PathVariable Long bookId, @RequestBody Book newBook) {
        Book updatedBook = bookService.editBook(bookId, newBook);
        if (updatedBook == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedBook);
    }

    @GetMapping("/init")
    public ResponseEntity<Void> initDB() {
        bookService.initDB();
        return ResponseEntity.ok().build();
    }
}

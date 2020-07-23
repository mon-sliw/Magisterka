package pl.mis.magisterka.bookinfoservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mis.magisterka.bookinfoservice.entity.Book;
import pl.mis.magisterka.bookinfoservice.service.BookService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookInfoController {

    BookService bookService;

    @RequestMapping("/{bookId}")
    public Book getBookById(@PathVariable int bookId){

        //return bookService.getBookById(bookId);
        return null;
    }
}

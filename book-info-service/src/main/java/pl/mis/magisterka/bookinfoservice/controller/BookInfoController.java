package pl.mis.magisterka.bookinfoservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mis.magisterka.bookinfoservice.entity.Book;

@RestController
@RequestMapping("/book")
public class BookInfoController {


    @RequestMapping("/{bookId}")
    public Book getBookInfo(@PathVariable int bookId){

        return null;
    }
}

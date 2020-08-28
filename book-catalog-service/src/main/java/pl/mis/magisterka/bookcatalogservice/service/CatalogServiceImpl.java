package pl.mis.magisterka.bookcatalogservice.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mis.magisterka.bookcatalogservice.entity.Book;
import pl.mis.magisterka.bookcatalogservice.entity.BookCatalog;
import pl.mis.magisterka.bookcatalogservice.entity.Rating;
import pl.mis.magisterka.bookcatalogservice.entity.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CatalogServiceImpl implements CatalogService {

    RestTemplate restTemplate;

    @Override
    public BookCatalog getCatalogByUserId(Long userId) {

        //get user info
        User user = restTemplate.getForObject("http://user-service/user/" + userId, User.class);

        //get ratings list
        ResponseEntity<Rating[]> ratingResponse = restTemplate.getForEntity("http://ratings-service/rating/user-id/" + userId, Rating[].class);
        List<Rating> ratingsList = Arrays.asList(ratingResponse.getBody());

        //get book info
        List<Book> bookInfoList = ratingsList.stream()
                .map(rating -> {
                    Book book = restTemplate.getForObject("http://book-info-service/book/" + rating.getBookId(), Book.class);
                    if (book != null)
                        book.setRating(rating.getRating());
                    return book;
                }).collect(Collectors.toList());

        return new BookCatalog(user, bookInfoList);
    }
}

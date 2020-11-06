package pl.mis.magisterka.searchservice.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mis.magisterka.searchservice.entity.Book;
import pl.mis.magisterka.searchservice.entity.Rating;
import pl.mis.magisterka.searchservice.entity.SearchResponse;
import pl.mis.magisterka.searchservice.entity.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SearchServiceImpl implements SearchService {

    RestTemplate restTemplate;

    @Override
    public SearchResponse getBooksBySearchString(Long userId, String searchString) {

        //get user info
        User user = restTemplate.getForObject("http://user-service/user/" + userId, User.class);
        //get ratings list
        ResponseEntity<Rating[]> ratingResponse =
                restTemplate.getForEntity("http://ratings-service/rating/user-id/" + userId, Rating[].class);
        Map<Long, Rating> ratingsMap = Arrays.stream(ratingResponse.getBody())
                .collect(Collectors.toMap(Rating::getBookId, Function.identity()));
        //get book info
        ResponseEntity<Book[]> booksResponse = restTemplate
                .getForEntity("http://book-info-service/book/search?string=" + searchString, Book[].class);
        List<Book> bookList = Arrays.asList(booksResponse.getBody());
        bookList.forEach(book -> book.setRating(ratingsMap.getOrDefault(book.getId(), new Rating()).getRating()));
        return new SearchResponse(user, searchString, bookList);
    }
}


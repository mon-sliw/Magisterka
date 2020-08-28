package pl.mis.magisterka.searchservice.service;

import pl.mis.magisterka.searchservice.entity.SearchResponse;

public interface SearchService {
    SearchResponse getBooksBySearchString(Long userId, String searchString);
}

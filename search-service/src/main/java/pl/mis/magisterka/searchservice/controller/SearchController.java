package pl.mis.magisterka.searchservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mis.magisterka.searchservice.entity.SearchResponse;
import pl.mis.magisterka.searchservice.service.SearchService;

@AllArgsConstructor
@RestController
@RequestMapping("/search")
public class SearchController {

    SearchService searchService;

    @GetMapping("/user-id/{userId}")
    public ResponseEntity<SearchResponse> getBooksBySearchString(@PathVariable Long userId, @RequestParam("string") String searchString) {
        return ResponseEntity.ok(searchService.getBooksBySearchString(userId, searchString));
    }
}

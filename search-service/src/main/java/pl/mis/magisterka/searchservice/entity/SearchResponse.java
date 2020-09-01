package pl.mis.magisterka.searchservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class SearchResponse {

    User user;

    String search;

    List<Book> results;
}

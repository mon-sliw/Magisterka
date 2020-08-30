package pl.mis.magisterka.searchservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class SearchResponse {

    User user;

    List<Book> results;

    String search;

}

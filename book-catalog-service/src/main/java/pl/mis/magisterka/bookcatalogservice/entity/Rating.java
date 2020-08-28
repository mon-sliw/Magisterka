package pl.mis.magisterka.bookcatalogservice.entity;

import lombok.Data;

@Data
public class Rating {

    private Long userId;

    private Long bookId;

    private Integer rating;
}

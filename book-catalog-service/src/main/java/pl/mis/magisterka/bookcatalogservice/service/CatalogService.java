package pl.mis.magisterka.bookcatalogservice.service;

import pl.mis.magisterka.bookcatalogservice.entity.BookCatalog;

public interface CatalogService {

    BookCatalog getCatalogByUserId(Long userId);
}

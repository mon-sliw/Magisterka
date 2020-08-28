package pl.mis.magisterka.bookcatalogservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mis.magisterka.bookcatalogservice.service.CatalogService;

@AllArgsConstructor
@RestController
@RequestMapping("/catalog")
public class CatalogController {

    CatalogService catalogService;

    @GetMapping("/{userId}")
    public ResponseEntity<?> getCatalogByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(catalogService.getCatalogByUserId(userId));
    }
}

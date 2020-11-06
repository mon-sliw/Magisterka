package pl.mis.magisterka.badania.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mis.magisterka.badania.service.BadaniaService;

@AllArgsConstructor
@RestController
@RequestMapping("/badania")
public class BadaniaController {

    BadaniaService service;

    @GetMapping("/test")
    public ResponseEntity<Void> test() {
        if (service.test())
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
}

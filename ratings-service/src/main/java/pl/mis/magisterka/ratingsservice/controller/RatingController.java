package pl.mis.magisterka.ratingsservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mis.magisterka.ratingsservice.entity.Rating;
import pl.mis.magisterka.ratingsservice.entity.RatingId;
import pl.mis.magisterka.ratingsservice.service.RatingService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/rating")
public class RatingController {

    RatingService ratingService;

    @GetMapping("/user-id/{userId}")
    public ResponseEntity<?> getRatingsByUserId(@PathVariable Long userId) {
        List<Rating> ratingsList = ratingService.getRatingsByUserId(userId);
        if (ratingsList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ratingsList);
    }

    @GetMapping("/user-id/{userId}/book-id/{bookId}")
    public ResponseEntity<?> getRatingById(@PathVariable Long userId, @PathVariable Long bookId) {
        return ratingService.getById(new RatingId(userId, bookId)).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> addRating(@RequestBody Rating rating) {
        Rating addedRating = ratingService.addRating(rating);
        if (addedRating == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.ok(addedRating);
    }

    @DeleteMapping("/user-id/{userId}/book-id/{bookId}")
    public ResponseEntity<Void> deleteRating(@PathVariable Long userId, @PathVariable Long bookId) {
        if (ratingService.deleteRating(new RatingId(userId, bookId)))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/user-id/{userId}/book-id/{bookId}")
    public ResponseEntity<?> editRating(@PathVariable Long userId, @PathVariable Long bookId, @RequestBody Rating newRating) {
        Rating updatedRating = ratingService.editRating(new RatingId(userId, bookId), newRating);
        if (updatedRating == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updatedRating);
    }

    @GetMapping("/init")
    public ResponseEntity<Void> initDB(){
        if (ratingService.initDB())
            return ResponseEntity.ok().build();
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }
}

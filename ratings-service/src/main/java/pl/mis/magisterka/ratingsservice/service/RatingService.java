package pl.mis.magisterka.ratingsservice.service;

import pl.mis.magisterka.ratingsservice.entity.Rating;
import pl.mis.magisterka.ratingsservice.entity.RatingId;

import java.util.List;
import java.util.Optional;

public interface RatingService {

    List<Rating> getRatingsByUserId(Long userId);

    Optional<Rating> getById(RatingId id);

    List<Rating> getAll();

    Rating addRating(Rating rating);

    boolean deleteRating(RatingId id);

    Rating editRating(RatingId id, Rating newRating);

}

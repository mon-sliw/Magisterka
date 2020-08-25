package pl.mis.magisterka.ratingsservice.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.mis.magisterka.ratingsservice.entity.Rating;
import pl.mis.magisterka.ratingsservice.entity.RatingId;
import pl.mis.magisterka.ratingsservice.repository.RatingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RatingServiceImpl implements RatingService {

    RatingRepository ratingRepository;

    @Override
    public List<Rating> getRatingsByUserId(Long userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public Optional<Rating> getById(RatingId id) {
        return ratingRepository.findById(id);
    }

    @Override
    public List<Rating> getAll() {
        List<Rating> allRatings = new ArrayList<>();
        ratingRepository.findAll().forEach(allRatings::add);
        return allRatings;
    }

    @Override
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public boolean deleteRating(RatingId id) {
        if (ratingRepository.existsById(id)) {
            ratingRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Rating editRating(RatingId id, Rating newRating) {
        Rating existingRating = ratingRepository.findById(id).orElse(null);
        if (existingRating != null) {
            existingRating.copy(newRating);
            ratingRepository.save(existingRating);
        }
        return existingRating;
    }
}

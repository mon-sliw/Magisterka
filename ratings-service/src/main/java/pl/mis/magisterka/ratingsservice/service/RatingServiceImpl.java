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
        if (ratingRepository.existsById(id)) {
            newRating.setBookId(id.getBookId());
            newRating.setUserId(id.getUserId());
            return ratingRepository.save(newRating);
        }
        return null;
    }

    @Override
    public boolean initDB() {
        try {
            List<Rating> ratings = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                long userId = Math.round(Math.random() * 50 + 1);
                long bookId = Math.round(Math.random() * 5812 + 1);
                int rating = (int) (Math.random() * 5 + 1);
                ratings.add(new Rating(userId, bookId, rating));
            }
            ratingRepository.saveAll(ratings);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

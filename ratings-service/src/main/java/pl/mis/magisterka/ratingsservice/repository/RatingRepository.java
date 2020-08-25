package pl.mis.magisterka.ratingsservice.repository;

import org.springframework.data.repository.CrudRepository;
import pl.mis.magisterka.ratingsservice.entity.Rating;
import pl.mis.magisterka.ratingsservice.entity.RatingId;

import java.util.List;

public interface RatingRepository extends CrudRepository<Rating, RatingId> {

    public List<Rating> findByUserId(Long userId);

}

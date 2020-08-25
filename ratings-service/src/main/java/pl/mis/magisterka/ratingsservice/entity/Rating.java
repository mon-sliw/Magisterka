package pl.mis.magisterka.ratingsservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(RatingId.class)
public class Rating {

    @Id
    private Long userId;

    @Id
    private Long bookId;

    private Integer rating;

    public void copy(Rating newRating) {
        this.rating = newRating.getRating();
    }
}

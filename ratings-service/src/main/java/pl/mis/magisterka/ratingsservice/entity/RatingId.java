package pl.mis.magisterka.ratingsservice.entity;

import java.io.Serializable;
import java.util.Objects;

public class RatingId implements Serializable {

    private Long userId;

    private Long bookId;

    public RatingId() {
    }

    public RatingId(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getBookId() {
        return bookId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RatingId ratingId = (RatingId) o;
        return userId.equals(ratingId.userId) &&
                bookId.equals(ratingId.bookId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, bookId);
    }
}

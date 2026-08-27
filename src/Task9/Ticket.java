package Task9;

import java.math.BigDecimal;

public class Ticket {
    private Long id;
    private Long movieId;
    private BigDecimal price;
    private boolean refunded;

    public Ticket(Long id, Long movieId, BigDecimal price, boolean refunded) {
        this.id = id;
        this.movieId = movieId;
        this.price = price;
        this.refunded = refunded;
    }

    public Long getId() {
        return id;
    }

    public Long getMovieId() {
        return movieId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isRefunded() {
        return refunded;
    }
}

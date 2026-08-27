package Task8;

import java.math.BigDecimal;

public class Reservation {
    private Long id;
    private String guestName;
    private String roomType;
    private int nights;
    private BigDecimal pricePerNight;
    private ReservationStatus status;

    public Reservation(Long id, String guestName, String roomType, int nights, BigDecimal pricePerNight, ReservationStatus status) {
        this.id = id;
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
        this.pricePerNight = pricePerNight;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    public BigDecimal getPricePerNight() {
        return pricePerNight;
    }

    public ReservationStatus getStatus() {
        return status;
    }
}

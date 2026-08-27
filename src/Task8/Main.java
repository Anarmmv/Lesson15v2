package Task8;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static Map<String, BigDecimal> calculateRevenueByRoomType(
            List<Reservation> reservations) {
        return reservations.stream()
                .filter(reservation -> reservation.getStatus() == ReservationStatus.COMPLETED ||
                        reservation.getStatus() == ReservationStatus.CONFIRMED)
                .collect(Collectors.groupingBy(Reservation::getRoomType,
                        Collectors.reducing(BigDecimal.ZERO,
                                r -> r.getPricePerNight().multiply(BigDecimal.valueOf(r.getNights())),
                                BigDecimal::add)
                ));
    }

    public static Optional<String> findMostProfitableRoomType(
            List<Reservation> reservations) {
        Map<String, BigDecimal> rooms = calculateRevenueByRoomType(reservations);

        return rooms.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);

    }

    public static Optional<String> findGuestWithMostNights(
            List<Reservation> reservations) {
        Map<String, Integer> nightsByGuest = reservations.stream()
                .filter(r -> r.getStatus() == ReservationStatus.CONFIRMED || r.getStatus() == ReservationStatus.COMPLETED)
                .collect(Collectors.groupingBy(
                        Reservation::getGuestName,
                        Collectors.summingInt(Reservation::getNights)
                ));
        return nightsByGuest.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);


    }

    public static Map<String, Double> calculateAverageNightsByRoomType(List<Reservation> reservations) {
        return reservations.stream()
                .filter(reservation -> reservation.getStatus() == ReservationStatus.COMPLETED ||
                        reservation.getStatus() == ReservationStatus.CONFIRMED)
                .collect(Collectors.groupingBy(Reservation::getRoomType,
                        Collectors.averagingInt(Reservation::getNights)));
    }

    public static void main(String[] args) {
        Reservation r1 = new Reservation(1L, "Anar", "Deluxe", 3,
                BigDecimal.valueOf(100), ReservationStatus.CONFIRMED);
        Reservation r2 = new Reservation(2L, "Anar", "Standard", 4,
                BigDecimal.valueOf(50), ReservationStatus.COMPLETED);
        Reservation r3 = new Reservation(3L, "Ali", "Deluxe", 5,
                BigDecimal.valueOf(100), ReservationStatus.CONFIRMED);
        Reservation r4 = new Reservation(4L, "Aysel", "Standard", 10,
                BigDecimal.valueOf(50), ReservationStatus.CANCELLED);

        List<Reservation> reservations = List.of(r1, r2, r3, r4);


        Map<String, BigDecimal> revenue = calculateRevenueByRoomType(reservations);
        System.out.println("Revenue by room type: " + revenue);


        Optional<String> mostProfitable = findMostProfitableRoomType(reservations);
        System.out.println("Most profitable room type: " + mostProfitable);


        Optional<String> guest = findGuestWithMostNights(reservations);
        System.out.println("Guest with most nights: " + guest);


        Map<String, Double> avgNights = calculateAverageNightsByRoomType(reservations);
        System.out.println("Average nights by room type: " + avgNights);
    }
}
package Task5;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {



        public static Map<FuelType, List<Car>> groupByFuelType(List<Car> cars) {

            return cars.stream()
                    .collect(Collectors.groupingBy(Car::getFuelType));
        }


        public static Map<FuelType, Optional<Car>> findMostExpensiveByFuelType(List<Car> cars) {

            return cars.stream()
                    .collect(Collectors.groupingBy(
                            Car::getFuelType,
                            Collectors.maxBy(Comparator.comparing(Car::getPrice))
                    ));
        }


        public static Map<FuelType, Double> averagePriceByFuelType(List<Car> cars) {

            return cars.stream()
                    .collect(Collectors.groupingBy(
                            Car::getFuelType,
                            Collectors.averagingDouble(
                                    car -> car.getPrice().doubleValue()
                            )
                    ));
        }

    static void main(String[] args) {

        List<Car> cars = List.of(
                new Car(1L, "Toyota", "Corolla",
                        FuelType.HYBRID, new BigDecimal(32000)),

                new Car(2L, "BMW", "320",
                        FuelType.PETROL, new BigDecimal(48000)),

                new Car(3L, "BYD", "Seal",
                        FuelType.ELECTRIC, new BigDecimal(52000)),

                new Car(4L, "Toyota", "Camry",
                        FuelType.HYBRID, new BigDecimal(45000)),

                new Car(5L, "Mercedes", "C200",
                        FuelType.PETROL, new BigDecimal(55000))
        );

        System.out.println(groupByFuelType(cars));
        System.out.println(findMostExpensiveByFuelType(cars));
        System.out.println(averagePriceByFuelType(cars));


    }

    }

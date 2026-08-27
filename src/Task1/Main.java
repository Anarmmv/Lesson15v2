package Task1;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {



 public static Optional<City> findLargestCity(List<City> cities){
    return cities.stream()
            .max(Comparator.comparingInt(City::getPopulation)) ;


 }

    static void main(String[] args) {

        List<City> cities = List.of(
                new City(1L,"Baku"  ,  2_300_000 , "Azerbaijan") ,
                new City(2L ,"Ganja" ,       330_000,"Azerbaijan"),
                new City(3L, "Sumqayit" , 350_000,"Azerbaijan"),
                new City(4L,"Sheki"  ,      68_000  ,"Azerbaijan")

        );

        Optional<City> result = findLargestCity(cities);
        System.out.println(result);
    }

}

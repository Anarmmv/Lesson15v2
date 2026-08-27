import java.util.List;
import java.util.Optional;

public class Task3 {
    public static Optional<Integer> findFirstWarmTemperature(
            List<Integer> temperatures) {
        return temperatures.stream()
                .filter(t -> t > 10)
                .findFirst();

    }
        public static Optional<Integer> findFirstHotTemperature(
                List<Integer> temperatures){
            return temperatures.stream()
                    .filter(t-> t > 20)
                    .findFirst() ;


    }

    static void main(String[] args) {
        List<Integer> temperatures = List.of(-5, 2, 4, 12, 18, 25, 31) ;

        Optional<Integer> result = findFirstWarmTemperature(temperatures) ;
        Optional<Integer> result2 = findFirstHotTemperature(temperatures) ;
        System.out.println("10 dan yuxari ilk temperatur : "+ result + "  20 den yuxari ilk temperatur: " + result2);



    }

}

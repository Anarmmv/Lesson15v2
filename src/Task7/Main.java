package Task7;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {



    public static Map<String, Integer> calculateTeamPoints(List<Match> matches) {
        return matches.stream()
                .flatMap(match -> Stream.of(
                        Map.entry(
                                match.getHomeTeam(),
                                match.getHomeGoals() > match.getAwayGoals() ? 3
                                        : match.getHomeGoals() == match.getAwayGoals() ? 1 : 0
                        ),
                        Map.entry(
                                match.getAwayTeam(),
                                match.getAwayGoals() > match.getHomeGoals() ? 3
                                        : match.getAwayGoals() == match.getHomeGoals() ? 1 : 0
                        )
                ))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingInt(Map.Entry::getValue)
                ));
    }

    public static Optional<String> findWinner(
            List<Match> matches){
        Map<String, Integer> results = calculateTeamPoints(matches) ;

        return  results.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey) ;

    }

    public static Optional<String> findTopGoalScorerTeam(
            List<Match> matches){
        return matches.stream()
                .flatMap(match ->Stream.of(
                        Map.entry(match.getHomeTeam(), match.getHomeGoals()),
                        Map.entry(match.getAwayTeam(), match.getAwayGoals())
                ))
                .collect(Collectors.groupingBy(Map.Entry::getKey,Collectors.summingInt(Map.Entry::getValue)))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey) ;
    }
     static void main(String[] args) {
        Match m1 = new Match("Barcelona", "Real Madrid", 2, 1);
        Match m2 = new Match("Arsenal", "Chelsea", 1, 1);
        Match m3 = new Match("Real Madrid", "Arsenal", 3, 0);
        Match m4 = new Match("Chelsea", "Barcelona", 0, 2);

        List<Match> matches = List.of(m1, m2, m3, m4);


        Map<String, Integer> points = calculateTeamPoints(matches);
        System.out.println("Team points: " + points);


        Optional<String> winner = findWinner(matches);
        winner.ifPresent(team -> System.out.println("Winner: " + team));


        Optional<String> topScorer = findTopGoalScorerTeam(matches);
        topScorer.ifPresent(team -> System.out.println("Top goal scorer team: " + team));
    }



}

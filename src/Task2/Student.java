package Task2;

public class Student {
    private Long id;
    private String name;
    private int score;

    public Student(Long id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}

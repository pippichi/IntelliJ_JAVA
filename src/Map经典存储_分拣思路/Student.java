package Map经典存储_分拣思路;

public class Student{
    private String name;
    private String NO;
    private double score;

    public Student(String name, String NO, double score) {
        this.name = name;
        this.NO = NO;
        this.score = score;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNO() {
        return NO;
    }

    public void setNO(String NO) {
        this.NO = NO;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", NO='" + NO + '\'' +
                ", score=" + score +
                '}';
    }
}
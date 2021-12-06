package Task3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
public class Student {
    private final String firstName;
    private final String lastName;
    private final String surname;
    private final List<Subject> subject;
    private final List<Mark> marks;
    static long idStatic = 0;
    private final long id;
    public Student(final String firstName, final String lastName, final String surname, final
    List<Subject> subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.surname = surname;
        this.subject = subject;
        this.marks = setMarkSubject();
        this.id = Student.idStatic++;
    }
    public long getId() {
        return id;
    }
    public List<Mark> getMarks() {
        return marks;
    }
    public List<Subject> getSubject() {
        return subject;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    String getSurname() {
        return surname;
    }

    public void addMark(final int value, final String nameSubject) {
        for (int i = 0; i < subject.size(); i++) {
            if (Objects.equals(subject.get(i).getNameSubject(), nameSubject)) {
                if (value > 12 || value < 0)
                    marks.get(i).getMark().add(12);
                else
                    marks.get(i).getMark().add(value);
            }
        }
    }
    private List<Mark> setMarkSubject() {
        final List<Mark> marks = new ArrayList<>();
        for (int i = 0; i < subject.size(); i++) {
            final Mark mark = new Mark();
            marks.add(mark);
        }
        return marks;
    }
    public double averageMark() {
        double sum = 0;
        int count = 0;
        for (final Mark mark : marks) {
            sum += mark.getMark().stream().mapToInt(value -> value).sum();
            count += mark.getMark().stream().mapToInt(value -> value).count();
        }
        if (count != 0)
            return sum / count;
        else
            return 0;

    }
    public List<Integer> englishSort() {
        for (int i = 0; i < subject.size(); i++) {
            if (subject.get(i).getNameSubject().equals("English")) {
                return marks.get(i).getMark().stream().collect(Collectors.toList());
            }
        }
        return (List<Integer>) new ArrayList<>().stream().distinct();
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + "," +
                " Name: " + this.getFirstName() + "," +
                " Last Name: " + this.getLastName() + "," +
                " Surname: " + this.getSurname() + "\n";
    }
}
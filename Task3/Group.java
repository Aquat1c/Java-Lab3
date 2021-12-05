package Task3;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
public class Group {
    private List<Student> students;
    public Group(final List<Student> students) {
        this.students = students;
    }
    public Student bestStudentStream() {
        return students.stream()
                .reduce((a, b) -> a.averageMark() > b.averageMark() ? a : b)
                .get();
    }
    public List<Student> markSorting() {
        return students.stream()
                .filter(e -> e.averageMark() > 3).collect(Collectors.toList());
    }
    public List<Student> nameSorting() {
        return students.stream()
                .sorted((o1, o2) -> {
                    if (!Objects.equals(o1.getLastName(), o2.getLastName()))
                        return o1.getLastName().compareTo(o2.getLastName());
                    else if (!Objects.equals(o1.getFirstName(), o2.getFirstName()))
                        return o1.getFirstName().compareTo(o2.getFirstName());
                    else return o1.getSurname().compareTo(o2.getSurname());
                }).collect(Collectors.toList());
    }
    public String lastnamesPrinting() {
        return students.stream()
                .map(Student::getLastName)
                .reduce((s1, s2) -> s1 + "-" + s2).orElse("-");
    }
    @Override
    public String toString() {
        String result = "";
        for (final Student student : students) {
            result += "Student { " + "name: " + student.getFirstName() +
                    ", lastname: " + student.getLastName();
            for (final Subject subject : student.getSubject()) {
                result += ", subject: " + subject.getNameSubject() + "{ ";
                for (final Integer txt :
                        student.getMarks().get(student.getSubject().indexOf(subject)).getMark())
                    result += txt + " ";
                result += "}";
            }
            result += " }" + '\n';
        }
        return result;
    }
    }
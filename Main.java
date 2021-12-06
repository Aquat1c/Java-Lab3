    package Task3;
    import java.util.ArrayList;
    import java.util.List;
    public class Main {
        public static void main(final String[] args) {
            final Subject math = new Subject("Math");
            final Subject english = new Subject("English");
            final Subject PE = new Subject("PE");
            final List<Subject> subjects = new ArrayList<>();
            subjects.add(math);
            subjects.add(english);
            subjects.add(PE);
            final Student s1 = new Student("Vasyl", "Ivaniv", "Petrovich", subjects);
            final Student s2 = new Student("Olexandr", "Mykhailov", "Anatoliyovich", subjects);
            final Student s3 = new Student("Andriy", "Andriiv", "Andriyovich", subjects);
            final List<Student> students = new ArrayList<>();
            students.add(s1);
            students.add(s2);
            students.add(s3);
            final StudentSimple studentSimples = new StudentSimple();
            studentSimples.transformed(students);
            students.get(0).addMark(5, "Math");
            students.get(1).addMark(5, "Math");
            students.get(2).addMark(5, "Math");
            students.get(0).addMark(4, "English");
            students.get(1).addMark(2, "English");
            students.get(2).addMark(5, "English");
            students.get(0).addMark(3, "PE");
            students.get(1).addMark(5, "PE");
            students.get(2).addMark(3, "PE");

            final Group group = new Group(students);
            System.out.println("Average mark is:" + s1.averageMark());
            System.out.println(s1.englishSort());
            System.out.println("Best student's information: " + group.bestStudentStream());
            System.out.println("Sorting without '3' mark: " + group.markSorting());
            System.out.println("Name sorting: " + group.nameSorting());
            System.out.println("Students' lastnames: " + group.lastnamesPrinting());
        }
    }
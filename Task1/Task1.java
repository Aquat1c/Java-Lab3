package Task1;

public class Task1 {
    public static void main(final String[] args) {
        final Password pass = new Password("s8314");
        final User user = new User("Mykhailo", "Hudyma", 18, 100000, pass);
        try {
            user.validate();
            System.out.println("Good values passed!");
        } catch (final ValidateException ve) {
            System.out.println(ve.getMessage());
            System.out.println("Error code: " + ve.getErrorCode());
        }
    }
}

package Task1;

import java.sql.PseudoColumnUsage;

public class User {
    private String firstName;
    private String lastName;
    private int age;
    private double id;
    private Password password;

    public User(final String firstName, final String lastName, final int age, final double id, final Password password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
        this.password = password;
    }

    public User() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public double getId() {
        return id;
    }

    public void setId(final float id) {
        this.id = id;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(final Password password) {
        this.password = password;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final User user = (User) o;
        return age == user.age && firstName.equals(user.firstName) && lastName.equals(user.lastName) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return age * firstName.length();
    }

    public void validate() throws ValidateException {
        if (getFirstName().length() < 2) {
            throw new ValidateException("First name is too short.", ErrorCode.ERROR_500);
        }
        if (getFirstName().length() > 20) {
            throw new ValidateException("First name is too long.", ErrorCode.ERROR_500);
        }
        if (getLastName().length() < 2) {
            throw new ValidateException("Last name is too short.", ErrorCode.ERROR_500);
        }
        if (getLastName().length() > 30) {
            throw new ValidateException("Last name is too long.", ErrorCode.ERROR_500);
        }
        if (getAge() < 16) {
            throw new ValidateException("Age is incorrect, user is too young.", ErrorCode.ERROR_500);
        }
        if (getAge() > 100) {
            throw new ValidateException("Age is incorrect, user is too old.", ErrorCode.ERROR_500);
        }
        if (getId() < 1) {
            throw new ValidateException("Wrong id", ErrorCode.ERROR_500);
        }
        if (getPassword().getPassword().length() < 8) {
            throw new ValidateException("Password is too short", ErrorCode.ERROR_400);
        }
        else {
            throw new ValidateException("Access granted", ErrorCode.OK_200);
        }
    }
}

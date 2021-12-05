package Task1;

public class Password {
    private String password;

    public Password(final String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Password Password = (Password) o;
        return password.equals(Password.password);
    }

    @Override
    public int hashCode() {
        return password.length() * 35;
    }
}

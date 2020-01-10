package library.bean;

import java.util.Objects;

public class Security {
    private String login;
    private String password;

    public Security(){}

    Security(String login, String password){
        this.login=login;
        this.password=password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Security security = (Security) o;
        return Objects.equals(login, security.login) &&
                Objects.equals(password, security.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password);
    }

    @Override
    public String toString() {
        return "Security{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

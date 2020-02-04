package library.bean;


import java.io.Serializable;
import java.util.Objects;


public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String login;
    private String password;
    private String name;
    private Email email;
    private String locale;
    private UserRole userRole;


    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String name, Email email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public User(int id, String login, String password, String name, Email email, String locale) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.locale = locale;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole role) {
        this.userRole = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(locale, user.locale) &&
                userRole == user.userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email=" + email +
                ", locale='" + locale + '\'' +
                ", userRole=" + userRole +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, email, locale, userRole);
    }

    public enum UserRole implements Serializable{
        ADMIN("admin"), USER("user");
        private String name;

        UserRole(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}


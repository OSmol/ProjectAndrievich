package library.bean;


import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class User implements Serializable {

    private int id;
    private String login;
    private String password;
    private String name;
    private String email;
    private boolean block;
    private String locale;
    private Role role;
    private List<Book> books;

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(String login, String password, String name, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
    }

    public User(int id, String login, String password, String name, String email, boolean block,
                String locale, Role role, List<Book>books) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.block = block;
        this.locale = locale;
        this.books=books;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                block == user.block &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(locale, user.locale) &&
                role == user.role &&
                Objects.equals(books, user.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, email, block, locale, role, books);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", block=" + block +
                ", locale='" + locale + '\'' +
                ", role=" + role +
                ", books=" + books +
                '}';
    }

    public enum Role {
        USER, ADMIN
    }
}

package library.bean;


import java.util.Objects;

public abstract class User {
    private int id;
    private String login;
    private String password;
    private String name;
    private String email;
    private boolean block;
    private String locale;
    private String role;
    //  private Role user = new Role("User");
    //   private Role admin = new Role("Admin");

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

    public User(int id, String login, String password, String name, String email, boolean block, String locale) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.name = name;
        this.block = block;
        this.locale = locale;
    }

    public static class User1 extends User {
        public User1(String login, String password) {
            super(login, password);
            setRole("User1");
        }
    }

    public static class Admin extends User {
        public Admin(int id, String login, String password, String name, String email, boolean block, String locale) {
            super(id,login, password, name, email, block, locale);
            setRole("Admin");
        }

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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
                Objects.equals(locale, user.locale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, name, email, block, locale);
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
                '}';
    }
}

package library.bean;


import java.io.Serializable;
import java.util.Objects;


public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private Security security;
    private String name;
    private Email email;
    private boolean block;
    private String locale;
    private UserRole userRole;


    public User() {
    }

    public User(String login, String password) {
        this.security = new Security(login, password);
    }

    public User(String login, String password, String name, Email email) {
        this.security = new Security(login, password);
        this.email = email;
        this.name = name;
    }

    public User(int id, String login, String password, String name, Email email, boolean block,
                String locale) {
        this.id = id;
        this.security = new Security(login, password);
        this.email = email;
        this.name = name;
        this.block = block;
        this.locale = locale;

    }

    public User(Security security) {
        this.security = security;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return security.getLogin();
    }


    public String getPassword() {
        return security.getPassword();
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
                block == user.block &&
                Objects.equals(security, user.security) &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(locale, user.locale) &&
                userRole == user.userRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, security, name, email, block, locale, userRole);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", security=" + security +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", block=" + block +
                ", locale='" + locale + '\'' +
                ", role=" + userRole +
                '}';
    }

    public enum UserRole {
        ADMIN("admin"), USER("user");
        private String name;

        UserRole(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Security {
        private String login;
        private String password;

        public Security() {
        }

        Security(String login, String password) {
            this.login = login;
            this.password = password;
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
            return "SecurityContextHolder{" +
                    "login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}

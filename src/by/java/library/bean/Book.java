package library.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String title;
    private Person author;
    private String publishingHouse;
    private int year;
    private Set<Genre> genres = new HashSet<>();
    private Set<Country> countries = new HashSet<>();
    private long isbn;
    private int countOfPages;
    private String language;
    private Person authorOfTranslation;
    private String description;
    private double averageMark;
    private Person customer;
    private double price;
    private boolean delete;
    private List<User>users;


    public Book() {
    }

    /**
     * Create new object with the given values
     *
     * @param id                  - id of book
     * @param title               - title of book
     * @param author              - author of book
     * @param publishingHouse     - publishing house ob book
     * @param year                - year of publication of the book
     * @param genres              - genre of book
     * @param countries           - book publishing country
     * @param isbn                - International Standard Book Number
     * @param countOfPages        - the number of pages in the book
     * @param language            - language of book text
     * @param authorOfTranslation - author of translation book
     * @param description         - description of book
     * @param customer            - users who bought this book
     * @param price               - price of book
     * @param delete              - meaning the book is deleted or not
     */
    public Book(int id, String title, Person author, String publishingHouse, int year,
                Set<Genre> genres, Set<Country> countries, long isbn, int countOfPages,
                String language, Person authorOfTranslation, String description, double averageMark,
                Person customer, double price, boolean delete, List<User> users) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.year = year;
        this.genres = genres;
        this.countries = countries;
        this.isbn = isbn;
        this.countOfPages = countOfPages;
        this.language = language;
        this.authorOfTranslation = authorOfTranslation;
        this.description = description;
        this.averageMark = averageMark;
        this.customer = customer;
        this.price = price;
        this.delete = delete;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Country> getCountries() {
        return countries;
    }

    public void setCountries(Set<Country> countries) {
        this.countries = countries;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Person getAuthorOfTranslation() {
        return authorOfTranslation;
    }

    public void setAuthorOfTranslation(Person authorOfTranslation) {
        this.authorOfTranslation = authorOfTranslation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAverageMark() {
        return averageMark;
    }

    public void setAverageMark(double averageMark) {
        this.averageMark = averageMark;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                year == book.year &&
                isbn == book.isbn &&
                countOfPages == book.countOfPages &&
                Double.compare(book.averageMark, averageMark) == 0 &&
                Double.compare(book.price, price) == 0 &&
                delete == book.delete &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publishingHouse, book.publishingHouse) &&
                Objects.equals(genres, book.genres) &&
                Objects.equals(countries, book.countries) &&
                Objects.equals(language, book.language) &&
                Objects.equals(authorOfTranslation, book.authorOfTranslation) &&
                Objects.equals(description, book.description) &&
                Objects.equals(customer, book.customer) &&
                Objects.equals(users, book.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, publishingHouse, year, genres, countries,
                isbn, countOfPages, language, authorOfTranslation, description, averageMark,
                customer, price, delete, users);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", year=" + year +
                ", genres=" + genres +
                ", countries=" + countries +
                ", isbn=" + isbn +
                ", countOfPages=" + countOfPages +
                ", language='" + language + '\'' +
                ", authorOfTranslation=" + authorOfTranslation +
                ", description='" + description + '\'' +
                ", averageMark=" + averageMark +
                ", customer=" + customer +
                ", price=" + price +
                ", delete=" + delete +
                ", users=" + users +
                '}';
    }
}


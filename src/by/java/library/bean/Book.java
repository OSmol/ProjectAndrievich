package library.bean;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class Book implements Serializable {
    private static final long serialVersionUID = 3L;
    private int id;
    private String title;
    private String author;
    private String publishingHouse;
    private int year;
    private String genre;
    private String country;
    private long isbn;
    private int countOfPages;
    private String language;
    private String authorOfTranslation;
    private String description;

    private String customer;
    private double price;
    private boolean delete;

  //  private BookType bookType;


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
     * @param genre              - genre of book
     * @param country           - book publishing country
     * @param isbn                - International Standard Book Number
     * @param countOfPages        - the number of pages in the book
     * @param language            - language of book text
     * @param authorOfTranslation - author of translation book
     * @param description         - description of book
     * @param customer            - users who bought this book
     * @param price               - price of book
     * @param delete              - meaning the book is deleted or not
     */
    public Book(int id, String title, String author, String publishingHouse, int year,
               String genre, String country, long isbn, int countOfPages,
                String language, String authorOfTranslation, String description,
                String customer, double price, boolean delete) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishingHouse = publishingHouse;
        this.year = year;
        this.genre = genre;
        this.country = country;
        this.isbn = isbn;
        this.countOfPages = countOfPages;
        this.language = language;
        this.authorOfTranslation = authorOfTranslation;
        this.description = description;

        this.customer = customer;
        this.price = price;
        this.delete = delete;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getAuthorOfTranslation() {
        return authorOfTranslation;
    }

    public void setAuthorOfTranslation(String authorOfTranslation) {
        this.authorOfTranslation = authorOfTranslation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                year == book.year &&
                isbn == book.isbn &&
                countOfPages == book.countOfPages &&

                Double.compare(book.price, price) == 0 &&
                delete == book.delete &&
                Objects.equals(title, book.title) &&
                Objects.equals(author, book.author) &&
                Objects.equals(publishingHouse, book.publishingHouse) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(country, book.country) &&
                Objects.equals(language, book.language) &&
                Objects.equals(authorOfTranslation, book.authorOfTranslation) &&
                Objects.equals(description, book.description) &&
                Objects.equals(customer, book.customer) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, publishingHouse, year, genre, country, isbn, countOfPages, language, authorOfTranslation, description,  customer, price, delete);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", publishingHouse='" + publishingHouse + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                ", countries=" + country +
                ", isbn=" + isbn +
                ", countOfPages=" + countOfPages +
                ", language='" + language + '\'' +
                ", authorOfTranslation=" + authorOfTranslation +
                ", description='" + description + '\'' +

                ", customer=" + customer +
                ", price=" + price +
                ", delete=" + delete  +
                '}';
    }

    public static class NameComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }

    public static class YearComparator implements Comparator<Book> {
        @Override
        public int compare(Book o1, Book o2) {
            Integer a = o1.getYear();
            Integer b = o2.getYear();
            return a.compareTo(b);
        }
    }

    public enum BookType implements Serializable {
        PAPERBOOK("Paper book"), EBOOK("eBook");
        String name;

        BookType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}


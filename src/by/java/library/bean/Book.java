package library.bean;

public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private String country;
    private int year;
    private double price;
    private double rating;
    private boolean delete;

    public Book() {
    }

    public Book(int id, String title, String author, String genre, String country, int year, double price, double rating, boolean delete) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.country = country;
        this.year = year;
        this.price = price;
        this.rating = rating;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete) {
        this.delete = delete;
    }
}

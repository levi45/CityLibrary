package model;

import java.math.BigDecimal;

public class Product{

    int ISBN;
    String title;
    int year;
    BigDecimal price;
    String Publisher_name;

    String author;

    public Product(int ISBN, String title, int year, BigDecimal price, String Publisher_name, String author){

        this.ISBN = ISBN;
        this.title = title;
        this.year = year;
        this.price = price;
        this.Publisher_name = Publisher_name;
        this.author = author;

    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getISBN() {
        return ISBN;
    }

    public int getYear() {
        return year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher_name() {
        return Publisher_name;
    }

    public String getTitle() {
        return title;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setPublisher_name(String publisher_name) {
        Publisher_name = publisher_name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
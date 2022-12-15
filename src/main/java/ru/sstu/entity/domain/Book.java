package ru.sstu.entity.domain;

public class Book {

    int bookId;
    String bookName;
    String description;
    String place;
    String pubclishingHouse;


    public Book() {

    }

    public Book(int bookId, String bookName, String pubclishingHouse,String place,String description) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.description = description;
        this.place = place;
        this.pubclishingHouse = pubclishingHouse;
    }

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getDescription() {
        return description;
    }

    public String getPlace() {
        return place;
    }

    public String getPubclishingHouse() {
        return pubclishingHouse;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", description='" + description + '\'' +
                ", place='" + place + '\'' +
                ", pubclishingHouse='" + pubclishingHouse + '\'' +
                '}';
    }
}

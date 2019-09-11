package com.company.AndresInciarteU1M5Summative.Dto;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private Integer bookId;
    private String isbn;
    private LocalDate publishDate;
    private Integer authorId;
    private String title;
    private Integer publisherId;
    private Long price;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookId.equals(book.bookId) &&
                isbn.equals(book.isbn) &&
                publishDate.equals(book.publishDate) &&
                authorId.equals(book.authorId) &&
                title.equals(book.title) &&
                publisherId.equals(book.publisherId) &&
                price.equals(book.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, isbn, publishDate, authorId, title, publisherId, price);
    }

}

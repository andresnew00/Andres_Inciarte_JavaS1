package com.company.AndresInciarteU1M5Summative.Dao;

import com.company.AndresInciarteU1M5Summative.Dto.Book;

import java.util.List;

public interface BookDao {
//    create, read, read all, update, and delete , and books by author

    /**
     * Create a new book
     * @param book
     * @return
     */
    Book createBook(Book book);

    /**
     * Read a book by id
     * @param id
     * @return
     */
    Book readBook(Integer id);

    /**
     * get a list of all the books in the db
     * @return
     */
    List<Book> readAllBooks();

    /**
     * Updating a book in the database
     * @param book
     */
    void updateBook(Book book);

    /**
     * Delete a book from the database
     * @param id
     */
    void deleteBook(Integer id);


}

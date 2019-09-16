package com.company.AndresInciarteU1M5Summative.Dao;

import com.company.AndresInciarteU1M5Summative.Dto.Author;

import java.util.List;

public interface AuthorDao {

    //create read read all update and delete

    /**
     * Creating an author
     * @param author
     * @return
     */
    Author createAuthor(Author author);

    /**
     * read author by Id
     * @param authorId
     * @return
     */
    Author readAuthor(int authorId);

    /**
     * Returning all authors
     * @return
     */
    List<Author> realAllAuthors();

    /**
     * Update an existing author
     * @param author
     */
    void updateAuthor(Author author);

    /**
     * Delete an author by id
     * @param authorId
     */
    void deleteAuthor(int authorId);

}

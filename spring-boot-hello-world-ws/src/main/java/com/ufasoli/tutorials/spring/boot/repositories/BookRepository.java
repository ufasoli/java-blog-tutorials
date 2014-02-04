package com.ufasoli.tutorials.spring.boot.repositories;

import com.ufasoli.tutorials.spring.boot.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 04.02.14
 * Time: 11:24
 */
@Repository
public interface BookRepository extends CrudRepository<Book, String> {

    public Iterable<Book> findBooksByAuthor(@Param("author") String author);
}

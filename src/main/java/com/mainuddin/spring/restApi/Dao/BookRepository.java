package com.mainuddin.spring.restApi.Dao;

import com.mainuddin.spring.restApi.Entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {
    public Book findById(int id);
}

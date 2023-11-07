package com.example.parctical3.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.parctical3.entity.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Integer> {
}

package lk.ijse.eca.bookservice.repository;

import lk.ijse.eca.bookservice.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}

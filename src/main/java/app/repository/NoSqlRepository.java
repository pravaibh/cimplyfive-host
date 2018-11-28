package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.document.User;

@Repository
public interface NoSqlRepository extends MongoRepository<User, String>{

}

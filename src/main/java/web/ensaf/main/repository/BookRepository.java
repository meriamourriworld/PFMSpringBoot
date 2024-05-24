package web.ensaf.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.ensaf.main.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}

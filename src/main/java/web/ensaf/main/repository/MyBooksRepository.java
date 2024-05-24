package web.ensaf.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.ensaf.main.model.MyBooks;

@Repository
public interface MyBooksRepository extends JpaRepository<MyBooks, Integer>{

}

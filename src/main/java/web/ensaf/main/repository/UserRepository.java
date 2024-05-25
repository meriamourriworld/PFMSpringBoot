package web.ensaf.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.ensaf.main.model.User;
import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	//Define findByUsername as default search method
	User findByUsername(String username);
}

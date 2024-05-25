package web.ensaf.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import web.ensaf.main.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}

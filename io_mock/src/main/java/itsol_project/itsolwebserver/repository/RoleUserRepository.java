package itsol_project.itsolwebserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itsol_project.itsolwebserver.entity.Role_user;

@Repository
public interface RoleUserRepository extends JpaRepository<Role_user, Long>{

}

package itsol_project.itsolwebserver.repository;

import itsol_project.itsolwebserver.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String username);
    Optional<User> findByUsername(String username);
    User findOneByUsername(String username);
    Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
}

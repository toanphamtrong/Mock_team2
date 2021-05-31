package itsol_project.itsolwebserver.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import itsol_project.itsolwebserver.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(String name);
	@Query( value = "SELECT r.* "
			+ " FROM Role r join role_user ur on r.id = ur.role_id"
			+ " WHERE ur.user_id = :user_id", nativeQuery = true)
	Set<Role> findRoleByUser(@Param("user_id") Long id);
}

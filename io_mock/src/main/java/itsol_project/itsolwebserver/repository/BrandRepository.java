package itsol_project.itsolwebserver.repository;

import itsol_project.itsolwebserver.dto.BrandDto;
import itsol_project.itsolwebserver.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface BrandRepository extends JpaRepository<Brand, Long> {
    @Query("select b from Brand b where lower(b.name) like concat('%', :name, '%')")
    List<Brand> search(String name);
}

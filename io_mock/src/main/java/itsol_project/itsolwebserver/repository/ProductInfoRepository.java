package itsol_project.itsolwebserver.repository;

import itsol_project.itsolwebserver.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {
}

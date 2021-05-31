package itsol_project.itsolwebserver.repository;

import itsol_project.itsolwebserver.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}

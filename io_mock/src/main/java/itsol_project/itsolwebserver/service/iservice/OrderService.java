package itsol_project.itsolwebserver.service.iservice;

import itsol_project.itsolwebserver.dto.OrderDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrderService extends BaseService{
    abstract List<OrderDto> findAll();

    List<OrderDto> findByUserId(HttpServletRequest request, Long id);
}

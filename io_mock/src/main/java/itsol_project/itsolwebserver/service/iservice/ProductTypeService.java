package itsol_project.itsolwebserver.service.iservice;

import itsol_project.itsolwebserver.dto.ProductTypeDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProductTypeService extends BaseService{
    List<ProductTypeDto> findAllCategory(HttpServletRequest request, Long id);
}

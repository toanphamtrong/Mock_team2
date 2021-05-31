package itsol_project.itsolwebserver.service.iservice;

import itsol_project.itsolwebserver.dto.ProductDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ProductService extends BaseService{
    List<ProductDto> search(HttpServletRequest request, ProductDto dto);

    abstract List<ProductDto> findAll();

    List<ProductDto> findNew();
    List<ProductDto>findSale();
    List<ProductDto> findAllBrand(HttpServletRequest request, Long id);
}

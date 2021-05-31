package itsol_project.itsolwebserver.service;

import itsol_project.itsolwebserver.dto.BaseDto;
import itsol_project.itsolwebserver.dto.ProductTypeDto;
import itsol_project.itsolwebserver.repository.ProductTypeRepository;
import itsol_project.itsolwebserver.service.iservice.ProductTypeService;
import itsol_project.itsolwebserver.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
public  class ProductTypeImpl implements ProductTypeService {
    @Autowired
    ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductTypeDto> findAll() {
        return productTypeRepository.getAllParent()
                .stream()
                .map(obj -> AppUtil.mapperEntAndDto(obj, ProductTypeDto.class))
                .collect(Collectors.toList());

    }


    @Override
    public <T extends BaseDto> T saveOrUpdate(HttpServletRequest request, Object object) {
        return null;
    }

    @Override
    public <T extends BaseDto> T findById(HttpServletRequest request, Long id) {
        return null;
    }

    @Override
    public Boolean delete(HttpServletRequest request, Long id) {
        return null;
    }


    @Override
    public List<ProductTypeDto> findAllCategory(HttpServletRequest request, Long id) {
        return productTypeRepository.getAllByCategory(id)
                .stream()
                .map(obj -> AppUtil.mapperEntAndDto(obj, ProductTypeDto.class)).
                        collect(Collectors.toList());
    }
}

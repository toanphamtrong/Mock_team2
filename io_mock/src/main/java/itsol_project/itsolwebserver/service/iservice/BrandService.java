package itsol_project.itsolwebserver.service.iservice;

import itsol_project.itsolwebserver.dto.BaseDto;
import itsol_project.itsolwebserver.dto.BrandDto;
import itsol_project.itsolwebserver.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BrandService {
    <T extends BaseDto> List<T> findAll();

    List<BrandDto> findAll(BrandDto dto);

    <T extends BaseDto> T saveOrUpdate(HttpServletRequest request, Object object);

    <T extends BaseDto> T findById(HttpServletRequest request, Long id);

    Boolean delete(HttpServletRequest request, Long id);

    List<BrandDto> search(BrandDto dto);
}

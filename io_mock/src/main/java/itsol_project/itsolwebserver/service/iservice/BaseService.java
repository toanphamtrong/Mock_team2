package itsol_project.itsolwebserver.service.iservice;

import itsol_project.itsolwebserver.dto.BaseDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BaseService {
    <T extends BaseDto> List<T> findAll();

    <T extends BaseDto> T saveOrUpdate(HttpServletRequest request, Object object);

    <T extends BaseDto> T findById(HttpServletRequest request, Long id);

    Boolean delete(HttpServletRequest request, Long id);
}

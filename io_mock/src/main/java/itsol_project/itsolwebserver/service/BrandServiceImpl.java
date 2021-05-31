package itsol_project.itsolwebserver.service;

import itsol_project.itsolwebserver.dto.BaseDto;
import itsol_project.itsolwebserver.dto.BrandDto;
import itsol_project.itsolwebserver.entity.Brand;
import itsol_project.itsolwebserver.repository.BrandRepository;
import itsol_project.itsolwebserver.repository.ProductRepository;
import itsol_project.itsolwebserver.service.iservice.BrandService;
import itsol_project.itsolwebserver.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<BrandDto> findAll(BrandDto dto) {
        return brandRepository.findAll()
                .stream()
                .map(obj -> AppUtil.mapperEntAndDto(obj, BrandDto.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public BrandDto saveOrUpdate(HttpServletRequest request, Object object) {
        BrandDto brandDTO=(BrandDto) object;
        Brand brand;
        if(brandDTO != null){
            //lưu thêm mới
            if(AppUtil.NVL(brandDTO.getId())==0L){
                brand = AppUtil.mapperEntAndDto(brandDTO, Brand.class);
                brand.setCreatedDate(new Date());
                brand.setUpdatedDate(new Date());
                brand.setName(brand.getName());
                brand.setCode(brand.getCode());
            }
            //update
            else {
                brand = brandRepository.findById(brandDTO.getId()).orElse(null);

                if (brand != null){
                    Brand dataBrand = AppUtil.mapperEntAndDto(brandDTO,Brand.class); // dataBrand sau khi map đã có dủ hết data r
                    dataBrand.setId(brand.getId());
                    dataBrand.setUpdatedDate(new Date()); // chỉ cần set ngày update thôi
                    brand = dataBrand;
                }

            }
            return  AppUtil.mapperEntAndDto(brandRepository.save(brand), BrandDto.class);

        }
        return null;

    }
    @Override
    public BrandDto findById(HttpServletRequest request, Long id) {
        Brand brand = brandRepository.findById(id).orElse(null);
        if (brand !=null){
            return AppUtil.mapperEntAndDto(brand, BrandDto.class);
        }

        return null;
    }

    @Override
    public <T extends BaseDto> List<T> findAll() {
        return null;
    }

    @Override
    @Transactional
    public Boolean delete(HttpServletRequest request, Long id) {
        Brand brand = brandRepository.findById(id).orElse(null);
        if(brand != null){
            productRepository.deleteAllByBrand(brand);
            brandRepository.delete(brand);
            return true;
        }

        return false;
    }

    @Override
    public List<BrandDto> search(BrandDto dto) {
        return brandRepository.search(dto.getName())
                .stream().map(brand -> AppUtil.mapperEntAndDto(brand, BrandDto.class))
                .collect(Collectors.toList());
    }

}

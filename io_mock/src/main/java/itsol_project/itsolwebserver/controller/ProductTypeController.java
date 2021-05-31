package itsol_project.itsolwebserver.controller;

import itsol_project.itsolwebserver.service.iservice.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/type")
@CrossOrigin("http://localhost:4200")
public class ProductTypeController {
    @Autowired
    ProductTypeService productTypeService;

    @GetMapping("/all")
    public ResponseEntity findAll(){
        return ResponseEntity.ok().body(productTypeService.findAll());
    }

    //laasy san pham theo id category
    @GetMapping("/{id}")
    public ResponseEntity categoryID(HttpServletRequest request, @PathVariable Long id){
        return  ResponseEntity.ok().body(productTypeService.findAllCategory(request, id));
    }
}

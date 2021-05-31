package itsol_project.itsolwebserver.controller;

import itsol_project.itsolwebserver.dto.UserDto;
import itsol_project.itsolwebserver.service.iservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("itsol/users")
@CrossOrigin("http://localhost:4200")
public class UserController {
    @Autowired
    UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity findAll(){
        return ResponseEntity.ok().body(userService.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity findById(HttpServletRequest request, @PathVariable Long id){
        return ResponseEntity.ok().body(userService.findById(request, id));
    }

    @PostMapping("")
    public ResponseEntity saveOrUpdate(HttpServletRequest request, @RequestBody UserDto dto){

        return ResponseEntity.ok().body(userService.saveOrUpdate(request, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(HttpServletRequest request, @PathVariable Long id){
        String message;
        Boolean result = userService.delete(request, id);
        if (result){
            message = "Delete success!";
            return ResponseEntity.ok().body(message);
        }
        return ResponseEntity.notFound().build();
    }
}

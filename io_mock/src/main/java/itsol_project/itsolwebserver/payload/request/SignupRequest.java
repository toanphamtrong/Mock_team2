package itsol_project.itsolwebserver.payload.request;

import java.util.Date;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
 
public class SignupRequest {
    private String username;
 
    private String email;
    
    private Set<String> role;
    
    private String password;
    
    private String fullname;
    
    private Date birthday;
    
    private String address;
    
    private String phone;
    
    private int status;
    
}
package itsol_project.itsolwebserver.service.iservice;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import itsol_project.itsolwebserver.dto.UserDto;

public interface UserService extends BaseService, UserDetailsService {
	UserDto getUserByUsername(String username);
}

package itsol_project.itsolwebserver.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import itsol_project.itsolwebserver.entity.Role;
import itsol_project.itsolwebserver.entity.User;
import itsol_project.itsolwebserver.repository.RoleRepository;
import itsol_project.itsolwebserver.repository.UserRepository;
import itsol_project.itsolwebserver.service.iservice.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: "+ username ));
		Set<Role> roles = repository.findRoleByUser(user.getId());
		return UserDetailsImpl.build(user, roles);
	}
}

package itsol_project.itsolwebserver.controller;

import itsol_project.itsolwebserver.entity.Role;
import itsol_project.itsolwebserver.entity.Role_user;
import itsol_project.itsolwebserver.entity.User;
import itsol_project.itsolwebserver.service.iservice.UserDetailsImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import itsol_project.itsolwebserver.payload.request.LoginRequest;
import itsol_project.itsolwebserver.payload.request.SignupRequest;
import itsol_project.itsolwebserver.payload.response.MessageResponse;
import itsol_project.itsolwebserver.payload.response.JwtResponse;
import itsol_project.itsolwebserver.security.jwt.JwtUtils;
import itsol_project.itsolwebserver.repository.UserRepository;
import itsol_project.itsolwebserver.repository.RoleUserRepository;
import itsol_project.itsolwebserver.repository.RoleRepository;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/itsol/auth")
@CrossOrigin("http://localhost:4200")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	RoleUserRepository userRoleRepository;

	@Autowired
	 PasswordEncoder passwordEncoder;
	

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

		if (userDetails.getStatus() == 1) {
			String jwt = jwtUtils.generateJwtToken(authentication);
			List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toList());

			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
					userDetails.getEmail(), roles));
		}else {
			return ResponseEntity.ok(new MessageResponse("User is locked"));
		}

	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest
//			,@RequestParam("file") MultipartFile file
			) {
//		String path = null;
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity.ok(new MessageResponse("ExistUsername"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity.ok(new MessageResponse("ExistEmail"));
		}
		
		// Create new user's account
		User user = new User(signUpRequest.getUsername(), passwordEncoder.encode(signUpRequest.getPassword()),
				signUpRequest.getEmail(), signUpRequest.getFullname(),
				signUpRequest.getBirthday(), signUpRequest.getAddress(), signUpRequest.getPhone(),
				 signUpRequest.getStatus());
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Role cannot be empty."));
		}
		for (String r : strRoles) {
			System.out.println(r);
			switch (r) {
			case "admin":
				Role adminRole = roleRepository.findByName("ROLE_ADMIN")
						.orElseThrow(() -> new NoSuchElementException());
				roles.add(adminRole);
				break;
			case "user":
				Role userRole = roleRepository.findByName("ROLE_USER")
						.orElseThrow(() -> new NoSuchElementException());
				roles.add(userRole);
				break;

			default:
				return ResponseEntity.badRequest().body(new MessageResponse("Error: Role is not found."));
			}
		}
		user.setStatus(1);
		userRepository.save(user);
		Long userId = userRepository.findOneByUsername(signUpRequest.getUsername()).getId();
		for( Role r : roles) {
			Role_user ur = new Role_user(userId, r.getId());
			userRoleRepository.save(ur);
		}

		return ResponseEntity.ok(new MessageResponse("Success!"));
	}

}

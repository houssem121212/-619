package tn.esprit.spring.control;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.playod.UserIdentityAvailability;
import tn.esprit.spring.playod.UserSummary;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.security.CurrentUser;
import tn.esprit.spring.security.UserPrincipal;
import tn.esprit.spring.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	
	@Autowired
	UserService UserService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping("/user/me")
	@PreAuthorize("hasRole('USER')")
	public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
		UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(),
		currentUser.getName());
		return userSummary;
	}

	@GetMapping("/user/checkUsernameAvailability")
	public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
		Boolean isAvailable = !userRepository.existsByUsername(username);
		return new UserIdentityAvailability(isAvailable);
	}

	@GetMapping("/user/checkEmailAvailability")
	public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
		Boolean isAvailable = !userRepository.existsByEmail(email);
		return new UserIdentityAvailability(isAvailable);
	}

	
	@GetMapping("/user/USERS")
	public List<User> GETUSERS(@RequestParam(value = "role") Long id) {
		 userRepository.findByRoles_Id(id);  
		
		 
		 
		 return userRepository.findByRoles_Id(id); 
	
	
	}

	
	@GetMapping("/user/USERS/salaire")
	public int GETUSERSsalaire(@RequestParam(value = "role") Long id) {	 
		 return UserService.somme(id) ; 

	}
	
	
}

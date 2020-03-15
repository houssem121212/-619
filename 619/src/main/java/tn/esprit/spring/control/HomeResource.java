package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.UserServiceImpl;

@RestController
public class HomeResource {

	
	@Autowired 
	UserRepository userRepository;
	
	@Autowired
	UserServiceImpl userService;
	
	
    @GetMapping("/")
    public String home() {
        return "Welcome";
    }

    @GetMapping("/user")
    public String user() {
        return "Welcome User";
    }

    @GetMapping("/admin")
    public String admin() {
        return "Welcome Admin";
    }
    
    
    
    @GetMapping("/retrieve-all-users")
	@ResponseBody
	public List<User> getUsers() {
		List<User> list = userService.retriveAllUser();
		return list;
	}
    
	@PostMapping("/add")
	@ResponseBody
	public String  addUser(@RequestBody User u) {
		User user = userService.addUser(u);
	
		return "useradded";
	}
	
	@GetMapping("/veriff")
	@ResponseBody
	public String  updateUser(@RequestBody User u) {
		String a = userService.updateUser(u);
	
		return a;
	}
	
	@GetMapping(value = "/users/{loginName}") 
	public ResponseEntity<User> findUserByLogin(@PathVariable("loginName") String login) { 
	java.util.Optional<User> user  = userRepository.findByUserName(login); 
	
	System.out.println(user);
if (user != null)
	
		return new ResponseEntity<User>(HttpStatus.FOUND); 
else
	return new ResponseEntity<User>(HttpStatus.NOT_FOUND); 		}
	
}


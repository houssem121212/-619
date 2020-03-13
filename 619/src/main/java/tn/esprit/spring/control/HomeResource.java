package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.UserServiceImpl;

@RestController
public class HomeResource {

	
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
	
}


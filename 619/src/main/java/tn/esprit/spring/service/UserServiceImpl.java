package tn.esprit.spring.service;





import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements UserSerivce{
	
@Autowired 
UserRepository userRepository;

@Autowired
private PasswordEncoder passwordEncoder;

private static final Logger L = LogManager.getLogger(UserServiceImpl.class);

public List<User> retriveAllUser(){
List<User> users = (List<User>) userRepository.findAll();

for (User user : users){
	
	L.info("user ++ : " + user);
}


return users;
}



public User addUser(User u){
	u.setPassword(passwordEncoder.encode(u.getPassword()));
	userRepository.save(u);
	return u;
}
public void deleteUser(String id){
	
	
}




public String updateUser(User u){
User u2 =  new User();
u2= 	userRepository.findById(u.getId()).get();
if (BCrypt.checkpw(	"dd", u2.getPassword()) )



	return "yes";else
return "no";
}



}



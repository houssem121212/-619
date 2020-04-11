package tn.esprit.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;


@Controller
@ResponseBody
@RequestMapping("/sendSimpleEmail")
public class simpleemailcontroller {
	 @Autowired
	    public JavaMailSender emailSender;
	 @Autowired
		UserRepository userReprository;
	 
	 // http://localhost:8081/SpringMVC/servlet/sendSimpleEmail/send
	 @PutMapping("/send")
		@ResponseBody
	    public String sendSimpleEmail() {
	    	List<User> l = userReprository.findAll();
	    	System.err.println(l);
	        // Create a Simple MailMessage.
	        SimpleMailMessage message = new SimpleMailMessage();
	         for(int i=0;i<l.size();i++)
	         {
	        message.setTo(l.get(i).getEmail());
	        message.setSubject("Test Simple Email");
	        message.setText("Hello, Im testing Simple Email");
	 
	        // Send Message!
	        this.emailSender.send(message);
	        
	         }
	 
	        return "Email Sent!";
	    }
}

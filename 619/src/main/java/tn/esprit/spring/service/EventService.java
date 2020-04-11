package tn.esprit.spring.service;


import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class EventService{

	@Autowired
	EventRepository eventReprository;
	@Autowired
	UserRepository userReprository;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	public String ajouterEvent (Event event){
		eventReprository.save(event);
		return "event sucess";
	}
	
	
	
	
	
	
	
	public void deleteEventById (Long eventId){
		
		Event EventId = eventReprository.findById(eventId).get();
		
		eventReprository.delete(EventId);
	}
	
	
	
	
	
	
	
//	
//	public void mettreAjourtitre_eventIdJPQL(String titre_event, long eventId) {
//		eventReprository.mettreAjourtitre_eventIdJPQL(titre_event, eventId);
//
//	}
	
	
	public void mettreAjourtitre_eventIdJPQL(String titre_event, long eventId) {
		Event event = eventReprository.findById(eventId).get();
		event.setTitre_event(titre_event);
		eventReprository.save(event);

	}
	
	
	
	
	
	
	
	
	
	
	public List<String>getAllTitleEventJPQL(){
		return eventReprository.TitleEvent();
		
	}
	
	
	
	
	public List<Event> getAllEvents(){
		return (List<Event>) eventReprository.findAll();
	}
	
	
	
	public 	List<Event> findEvent(String name) {
	List<Event> eventList = eventReprository.findEventsByName(name);
	System.out.println("Employee list: " + eventList);
	return eventList;
	}
	
	
	
	
	
	public void onApplicationEvent(InteractiveAuthenticationSuccessEvent eventId)
    {
       User user = (User) eventId.getAuthentication().getPrincipal();
        System.out.println("LOGIN name: "+user.getUsername());
    }
	
	
	//SEND MAIL
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	 // List<Event> findAll();
	  //  List<Event> findLatest4();
	   // List<Event> findLatest5();
	  //  Event findByEventID(int eventID);
	
//	 public List<Event> findLatest(int num){
//	        List<Event> allEvents = (List<Event>) eventReprository.findAll();
//	        Collections.sort(allEvents, new Comparator<Event>(){
//	            @Override
//	           // public int compare(Event e1, Event e2){
//	             //   return e2.getDateStartEvent().compareTo(e1.getDateStartEvent());
//	            }
//	        });
//	        for(int i=allEvents.size()-1; i>=num; i--){
//	            allEvents.remove(i);
//	        }
//	        return allEvents;                
//	    }
//
//	@Override
//	public void deleteEventById(int eventId) {
//		// TODO Auto-generated method stub
//		
//	}
//	 
	 
}

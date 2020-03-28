package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	
	
	  @Query("SELECT titre_event FROM Event")
	    public List<String> TitleEvent();
	  
	
	  @Modifying
	    @Transactional
	    @Query("UPDATE Event e SET e.titre_event=:titre_event1 where e.id=:eventId")
	    public void mettreAjourtitre_eventIdJPQL(@Param("titre_event1")String titre, @Param("eventId")int eventId);
	  
	   //public List<String> findByEventCategory(String eventCategory);
	  //  public List<String> findByOrganizerID(Long organizerID);
	   // public List<String> findByStatus(boolean status);
	    //public Event findByEventId(int eventID);
	  //  public List<Event> findByLocationContaining(String location);
	    //public List<Event> findByEventNameContaining(String location);
	  //  public List<Event> findByEventNameContainingOrLocationContaining(String eventName, String location);
}

package tn.esprit.spring.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Command;



@Repository
public interface CommandRepository extends JpaRepository<Command, Long>{

	@Query("Select c from Command c join c.produits p where c.commandType=:type")
	public List<Command> findByType(@Param("type") String type);
	
}

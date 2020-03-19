package tn.esprit.spring.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
Optional< User> findByUserName(String userName);
}

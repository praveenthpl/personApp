package net.guides.person.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.person.crud.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}

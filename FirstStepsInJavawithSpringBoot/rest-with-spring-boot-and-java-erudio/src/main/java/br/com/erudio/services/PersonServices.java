package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repositories.PersonRepository;


@Service
public class PersonServices {
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	@Autowired
	PersonRepository repository;
	
	public List<Person> findAll() {
		logger.info("Finding all people!");
		
		return repository.findAll();
	}
	
	

	public Person findById(Long id) {
		logger.info("Finding one person"); 
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
	}
	
	public Person create(Person person) {
		logger.info("Creating one person"); 
		return repository.save(person);
	}
	
	public Person update(Person person) {
		logger.info("Updating one person"); 
		
//		vou ate o banco de dados recupero a pessoa pelo ID e passo ela pala variavel entity
		var entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
		
//		aqui sao setados os novos valores para cada campo desejado obtidos a partir do banco de dados
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		
		return repository.save(person);
	}
	
	public void delete(Long id) {
		logger.info("Deleting one person"); 
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!")); 
		repository.delete(entity);
	}

}

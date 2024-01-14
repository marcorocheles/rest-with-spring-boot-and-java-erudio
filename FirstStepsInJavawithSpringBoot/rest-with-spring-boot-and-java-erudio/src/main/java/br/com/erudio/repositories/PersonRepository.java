package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.erudio.model.Person;

@Repository
//permite todas as acoes possiveis dentro de um banco de dados
public interface PersonRepository extends JpaRepository<Person, Long> {

}

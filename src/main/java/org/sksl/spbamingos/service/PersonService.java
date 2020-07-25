package org.sksl.spbamingos.service;

import org.sksl.spbamingos.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {
    public int addPerson(Person person);

    public List<Person> getAllPeople();

    public Optional<Person> getPersonById(String id);

    public int deletePerson(String id);

    public int updatePerson(String id, Person newPerson);
}
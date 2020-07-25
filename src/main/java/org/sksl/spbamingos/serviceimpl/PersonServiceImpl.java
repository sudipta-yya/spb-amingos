package org.sksl.spbamingos.serviceimpl;

import org.sksl.spbamingos.dao.PersonDao;
import org.sksl.spbamingos.model.Person;
import org.sksl.spbamingos.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(@Qualifier("Sql") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person) {
        return personDao.insertPerson(person);
    }

    public List<Person> getAllPeople() {
        return personDao.selectAllPeople();
    }

    public Optional<Person> getPersonById(String id) {
        return personDao.selectPersonById(id);
    }

    public int deletePerson(String id) {
        return personDao.deletePersonById(id);
    }

    public int updatePerson(String id, Person newPerson) {
        return personDao.updatePersonById(id, newPerson);
    }
}

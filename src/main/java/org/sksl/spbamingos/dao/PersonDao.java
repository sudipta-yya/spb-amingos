package org.sksl.spbamingos.dao;

import org.sksl.spbamingos.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    //    IF String IS PRESENT THEN INSERT
    int insertPerson(String id, Person person);

    //    IF String IS NOT PRESENT THEN GENERATE FIRST & THEN INSERT
    default int insertPerson(Person person) {
        String id = UUID.randomUUID().toString();
        return insertPerson(id, person);
    }

    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(String id);

    int deletePersonById(String id);

    int updatePersonById(String id, Person person);
}

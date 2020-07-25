package org.sksl.spbamingos.daoimpl;

import org.sksl.spbamingos.dao.PersonDao;
import org.sksl.spbamingos.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("Test")
public class PersonDaoImplTest implements PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(String id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(String id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(String id) {
        Optional<Person> optionalPerson = selectPersonById(id);
        if (optionalPerson.isPresent()) {
            DB.remove(optionalPerson.get());
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int updatePersonById(String id, Person person) {
        if (deletePersonById(id) == 0) {
            return 0;
        }
        return insertPerson(id, person);
    }
}

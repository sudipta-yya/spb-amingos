package org.sksl.spbamingos.controller;

import org.sksl.spbamingos.model.Person;
import org.sksl.spbamingos.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@Valid @NotNull @RequestBody Person person) {
        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") String id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") String id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePersonById(@PathVariable("id") String id,
                                 @Valid @NotNull @RequestBody Person newPerson) {
        personService.updatePerson(id, newPerson);
    }
}

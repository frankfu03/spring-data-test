package au.com.frankdev.spring.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import au.com.frankdev.spring.model.Person;
import au.com.frankdev.spring.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    PersonRepository<Person> personRepository;

    @Transactional
    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    @Transactional
    public List<Person> findByName(String name) {
        return personRepository.findByFirstName(name);
    }

    @Transactional
    public Person getById(Long id) {
        return personRepository.findById(id);
    }

    @Transactional
    public void deletePerson(Long id) {
        personRepository.delete(id);
    }

    @Transactional
    public boolean addPerson(Person person) {
        return personRepository.save(person) != null;
    }

    @Transactional
    public boolean updatePerson(Person person) {
        return personRepository.save(person) != null;
    }
}

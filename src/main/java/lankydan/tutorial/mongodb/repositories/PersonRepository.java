package lankydan.tutorial.mongodb.repositories;

import lankydan.tutorial.mongodb.entities.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {

  List<Person> findBySalary(final int salary);

}

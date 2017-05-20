package lankydan.tutorial.mongodb.application;

import lankydan.tutorial.mongodb.entities.Person;
import lankydan.tutorial.mongodb.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDateTime;

@SpringBootApplication
// needed because the repository is not in the same package or a sub package of the SpringBootApplication
@EnableMongoRepositories(basePackageClasses = PersonRepository.class)
public class Application implements CommandLineRunner {

  @Autowired private PersonRepository personRepository;

  public static void main(final String args[]) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {
    personRepository.deleteAll();

    final Person john = new Person("John", "Doe", LocalDateTime.now(), "Winner", 100);
    final Person joe = new Person("Joe", "Blogs", LocalDateTime.now(), "Loser", 50);

    personRepository.save(john);
    personRepository.save(joe);

    System.out.println("Find all");
    personRepository.findAll().forEach(System.out::println);

    System.out.println("Find by findBySalary");
    personRepository.findBySalary(100).forEach(System.out::println);

    System.out.println("Making John a loser");
    john.setProfession("Loser");
    personRepository.save(john);

    System.out.println("Find all");
    personRepository.findAll().forEach(System.out::println);
  }
}

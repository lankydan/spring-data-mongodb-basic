package lankydan.tutorial.mongodb.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString(exclude = {"id", "dateOfBirth"})
public class Person {

  @Id
  private String id;

  // not annotated as it is assumed that they will be mapped
  // onto db fields that have the same name as the properties
  private String firstName;
  private String secondName;
  private LocalDateTime dateOfBirth;
  private String profession;
  private int salary;

  public Person(
      final String firstName,
      final String secondName,
      final LocalDateTime dateOfBirth,
      final String profession,
      final int salary) {
    this.firstName = firstName;
    this.secondName = secondName;
    this.dateOfBirth = dateOfBirth;
    this.profession = profession;
    this.salary = salary;
  }

  // Lombok adds the getters and setters
}

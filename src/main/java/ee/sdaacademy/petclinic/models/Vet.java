package ee.sdaacademy.petclinic.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vet")
@Getter
@Setter
public class Vet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer vetId;
    String firstName;
    String lastName;
    Date dateOfBirth;
    String address;
    String telephoneNumber;
    String email;

    @OneToMany(mappedBy = "vet", cascade = CascadeType.ALL)
    List<Pet> petList;
}

package ee.sdaacademy.petclinic.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer petId;
    String name;
    Date dateOfBirth;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "petTypeId")
    PetType petType;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ownerId")
    Owner owner;
    int isVaccinated;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vetId")
    Vet vet;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "consultantId")
    Consultant consultant;
    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JoinColumn(name = "appointmentId")
    List<Appointment> appointmentList;
}

package ee.sdaacademy.petclinic.models;

import lombok.*;

import javax.persistence.*;
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
    @ManyToOne
    @JoinColumn(name = "petTypeId")
    PetType petType;
    @ManyToOne
    @JoinColumn(name = "ownerId")
    Owner owner;
    int isVaccinated;
    @ManyToOne
    @JoinColumn(name = "vetId")
    Vet vet;
    @ManyToOne
    @JoinColumn(name = "consultantId")
    Consultant consultant;
    @OneToMany(mappedBy = "pet", fetch = FetchType.EAGER)
    //@JoinColumn(name = "appointmentId")
    List<Appointment> appointmentList;
}

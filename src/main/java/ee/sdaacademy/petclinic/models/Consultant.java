package ee.sdaacademy.petclinic.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer consultantId;
    String name;
    @OneToMany(mappedBy = "consultant", fetch = FetchType.EAGER)
    List<Appointment> appointmentList;

    @OneToMany(mappedBy = "consultant", cascade = CascadeType.ALL)
    List<Pet> petList;
}

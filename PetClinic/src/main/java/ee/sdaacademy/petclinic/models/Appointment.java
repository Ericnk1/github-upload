package ee.sdaacademy.petclinic.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer appointmentId;
    String description;
    Date date; //date of consultation
    Time time;
    @ManyToOne
    @JoinColumn(name = "consultantId")
    Consultant consultant;
    @ManyToOne
    @JoinColumn(name = "petId")
    Pet pet;
}

package ee.sdaacademy.petclinic.repositories;

import ee.sdaacademy.petclinic.configs.HibernateUtils;
import ee.sdaacademy.petclinic.models.Appointment;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AppointmentRepository {

    //find all appointment
    public List<Appointment> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Appointment> appointments =
                session.createQuery("select appointment from Appointment appointment", Appointment.class)
                        .getResultList();
        session.close();
        return appointments;
    }

    //find vet by appointment id
    public Appointment findById(Integer id){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Appointment appointment = session.find(Appointment.class, id);
        session.close();
        return appointment;
    };

    //save to database
    public void save(Appointment appointment){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(appointment);
        transaction.commit();
        session.close();
    };

    //delete from database
    public void delete(Appointment appointment){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(appointment);
        transaction.commit();
        session.close();
    };

    //delete from database by appointment id
    public void deleteById(Appointment appointmentId){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(appointmentId);
        transaction.commit();
        session.close();
    }

    //update database
    public void update(Appointment appointment){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(appointment);
        transaction.commit();
        session.close();
    };
}

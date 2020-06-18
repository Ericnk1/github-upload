package ee.sdaacademy.petclinic.repositories;

import ee.sdaacademy.petclinic.configs.HibernateUtils;
import ee.sdaacademy.petclinic.models.PetType;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PetTypeRepository {

    //find all PetTypes
    public List<PetType> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<PetType> petTypes = session.createQuery("select petType from PetType petType ", PetType.class).getResultList();
        session.close();
        return petTypes;
    }

    //find PetType by PetType id
    public PetType findById(Integer id){
        Session session = HibernateUtils.getSessionFactory().openSession();
        PetType petType = session.find(PetType.class, id);
        session.close();
        return petType;
    };

    //save to database
    public void save(PetType petType){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(petType);
        transaction.commit();
        session.close();
    };

    //delete from database
    public void delete(PetType petType){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(petType);
        transaction.commit();
        session.close();
    };

    //delete from database by petType id
    public void deleteById(PetType petTypeId){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(petTypeId);
        transaction.commit();
        session.close();
    }

    //update database
    public void update(PetType petType){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(petType);
        transaction.commit();
        session.close();
    };
}

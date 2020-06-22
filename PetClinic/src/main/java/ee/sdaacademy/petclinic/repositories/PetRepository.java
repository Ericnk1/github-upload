package ee.sdaacademy.petclinic.repositories;

import ee.sdaacademy.petclinic.configs.HibernateUtils;
import ee.sdaacademy.petclinic.models.Pet;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PetRepository {

    //find all Pets
    public static List<Pet> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Pet> pet = session.createQuery("select pet " +
                "from Pet pet ", Pet.class).getResultList();
        session.close();
        return pet;
    }

    //find Pet by Pet alphabetically
    public static List <Pet> findAllAlphabetically() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Pet> pet = session.createQuery("select pet" +
                " from Pet pet order by Name", Pet.class)
                .getResultList();
        return pet;
    };

    //find Pets by id
    public static Pet findById(Integer id){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Pet pet = session.find(Pet.class, id);
        session.close();
        return pet;
    };

    //save to database
    public static void save(Pet pet){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(pet);
        transaction.commit();
        session.close();
    };

    //delete from database
    public static void delete(Pet pet){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(pet);
        transaction.commit();
        session.close();
    };

    //delete from database by Pets id
    public static void deleteById(Pet petId){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(petId);
        transaction.commit();
        session.close();
    };

    //update database
    public static void update(Pet pet){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(pet);
        transaction.commit();
        session.close();
    };
}

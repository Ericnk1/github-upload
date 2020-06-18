package ee.sdaacademy.petclinic.repositories;

import ee.sdaacademy.petclinic.configs.HibernateUtils;
import ee.sdaacademy.petclinic.models.Owner;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OwnerRepository {

    //find all Owners
    public List<Owner> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Owner> owner = session.createQuery("select owner from Owner owner ", Owner.class).getResultList();
        session.close();
        return owner;
    }

    //find Owner by Owner alphabetically
    public List <Owner> findAllAlphabetically() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Owner> owner = session.createQuery("select owner from Owner owner order by owner.firstName", Owner.class)
                .getResultList();
        return owner;
    };

    //find Owners by id
    public Owner findById(Integer id){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Owner owner = session.find(Owner.class, id);
        session.close();
        return owner;
    };

    //save to database
    public void save(Owner owner){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(owner);
        transaction.commit();
        session.close();
    };

    //delete from database
    public void delete(Owner owner){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(owner);
        transaction.commit();
        session.close();
    };

    //delete from database by Owners id
    public void deleteById(Owner ownerId){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(ownerId);
        transaction.commit();
        session.close();
    };

    //update database
    public void update(Owner owner){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(owner);
        transaction.commit();
        session.close();
    };
}

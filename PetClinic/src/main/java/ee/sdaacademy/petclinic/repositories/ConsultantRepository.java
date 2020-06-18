package ee.sdaacademy.petclinic.repositories;

import ee.sdaacademy.petclinic.configs.HibernateUtils;
import ee.sdaacademy.petclinic.models.Consultant;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ConsultantRepository {

    //find all consultants
    public List<Consultant> findAll(){
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Consultant> consultants = session.createQuery("select consultant from Consultant consultant ", Consultant.class).getResultList();
        session.close();
        return consultants;
    }

    //find consultant by consultant alphabetically
    public List <Consultant> findAllAlphabetically() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Consultant> consultant = session.createQuery("select consultant from Consultant consultant order by consultant.firstName", Consultant.class)
                .getResultList();
        return consultant;
    };

    //find consultants by id
    public Consultant findById(Integer id){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Consultant consultant = session.find(Consultant.class, id);
        session.close();
        return consultant;
    };

    //save to database
    public void save(Consultant consultant){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(consultant);
        transaction.commit();
        session.close();
    };

    //delete from database
    public void delete(Consultant consultant){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(consultant);
        transaction.commit();
        session.close();
    };

    //delete from database by consultants id
    public void deleteById(Consultant consultantId){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(consultantId);
        transaction.commit();
        session.close();
    };

    //update database
    public void update(Consultant consultant){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(consultant);
        transaction.commit();
        session.close();
    };
}

package ee.sdaacademy.petclinic.repositories;

import ee.sdaacademy.petclinic.configs.HibernateUtils;
import ee.sdaacademy.petclinic.models.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AdminRepository {

    //find all admins
    public static List<Admin> findAll() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<Admin> admins =
                session.createQuery("select admin from Admin admin", Admin.class)
                        .getResultList();
        session.close();
        return admins;
    }

    //find vet by admin id
    public static Admin findById(Integer id){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Admin admin = session.find(Admin.class, id);
        session.close();
        return admin;
    };

    //save to database
    public static void save(Admin admin){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(admin);
        transaction.commit();
        session.close();
    };

    //delete from database
    public static void delete(Admin admin){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(admin);
        transaction.commit();
        session.close();
    };

    //delete from database by admin id
    public static void deleteById(Admin adminId){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(adminId);
        transaction.commit();
        session.close();
    }

    //update database
    public static void update(Admin admin){
        Session session = HibernateUtils.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(admin);
        transaction.commit();
        session.close();
    };
}

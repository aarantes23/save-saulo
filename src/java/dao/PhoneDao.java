/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import java.util.List;
import model.Phone;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Arthur Arantes Faria <arthurarantes23@hotmail.com>
 */
public class PhoneDao {

    public PhoneDao() {
    }
        
    public List<Phone> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            List<Phone> list = session.createQuery("from Phone order by id").list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
    }

    public Phone search(int idPhone) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            Phone phone = (Phone) session.createQuery("from Phone where id = " + idPhone).uniqueResult();
            session.getTransaction().commit();
            return phone;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean insert(Phone phone) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(phone);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean change(Phone phone) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.update(phone);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean delete(Phone phone) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.delete(phone);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

}
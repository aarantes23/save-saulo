/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import java.util.List;
import model.Contact;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Arthur Arantes Faria <arthurarantes23@hotmail.com>
 */
public class ContactDao {

    public ContactDao() {
    }
    
    public List<Contact> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            List<Contact> list = session.createQuery("from Contact order by id").list();
            session.getTransaction().commit();
            return list;
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public Contact search(int idContact) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            Contact contact = (Contact) session.createQuery("from Contact where id = " + idContact).uniqueResult();
            session.getTransaction().commit();
            return contact;
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean insert(Contact contact) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(contact);
            session.getTransaction().commit();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean change(Contact contact) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.update(contact);
            session.getTransaction().commit();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean delete(Contact contact) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.delete(contact);
            session.getTransaction().commit();
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            session.getTransaction().rollback();
            return false;
        }
    }

}

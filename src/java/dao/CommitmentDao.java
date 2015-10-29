/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import java.util.List;
import model.Commitment;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Arthur Arantes Faria <arthurarantes23@hotmail.com>
 */
public class CommitmentDao {

    public CommitmentDao() {
    }

    public List<Commitment> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            List<Commitment> list = session.createQuery("from Commitment order by id").list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
    }

    public Commitment search(int idCommitment) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            Commitment commitment = (Commitment) session.createQuery("from Commitment where id = " + idCommitment).uniqueResult();
            session.getTransaction().commit();
            return commitment;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean insert(Commitment commitment) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(commitment);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean change(Commitment commitment) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.update(commitment);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean delete(Commitment commitment) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.delete(commitment);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

}

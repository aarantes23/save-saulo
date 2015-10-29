/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package dao;

import java.util.List;
import model.City;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Arthur Arantes Faria <arthurarantes23@hotmail.com>
 */
public class CityDao {

    public CityDao() {
    }    

    public List<City> list() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            List<City> list = session.createQuery("from City order by id").list();
            session.getTransaction().commit();
            return list;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
    }

    public City search(int idCity) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            City city = (City) session.createQuery("from City where id = " + idCity).uniqueResult();
            session.getTransaction().commit();
            return city;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        }
    }

    public boolean insert(City city) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.save(city);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean change(City city) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.update(city);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

    public boolean delete(City city) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        try {
            session.delete(city);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

}

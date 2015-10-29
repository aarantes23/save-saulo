/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package controler;

import dao.CityDao;
import dao.ContactDao;
import model.Contact;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.City;

/**
 *
 * @author Arthur
 */
@ManagedBean(name = "controlerContactMB")
@SessionScoped
public class ControlerContact implements Serializable {

    private List<Contact> list;
    private Contact contact;
    private Boolean status; // If Status = true then the contact is new, else the user is editing
    private int i;
    private final ContactDao contactDao;
    private int idCity;
    private City city;

    /**
     * Creates a new instance of controlerContact
     */
    public ControlerContact() {
        status = true;
        contactDao = new ContactDao();
        list = new ArrayList();
        list = contactDao.list();
        i = 0;
    }

    public String newContact() {
        contact = new Contact();
        status = true;
        return "insertContact";
    }

    public String remove(Contact contact) {
        if (contactDao.delete(contact)) {
            list = contactDao.list();
            util.UtilMensagens.success("Sucess");
            return "viewContact?faces-redirect=true";
        } else {
            util.UtilMensagens.erro("Erro");
            return null;
        }
    }

    private void defineCity() {
        CityDao cityDao = new CityDao();
        city = cityDao.search(idCity);
        contact.setIdCity(city);
    }

    public String insert() {
        defineCity();
        if (contactDao.insert(contact)) {
            list = contactDao.list();
            util.UtilMensagens.success("Sucess");
            return "viewContact";
        } else {
            util.UtilMensagens.erro("Erro");
            return null;
        }
    }

    public String change(Contact contact) {
        this.contact = contact;
        contact.setBirthDate(null);// Clear the calendars
        status = false;
        return "insertContact";
    }

    public String makeChange() {
        defineCity();
        if (contactDao.change(contact)) {
            list = contactDao.list();
            util.UtilMensagens.success("Sucess");
            return "viewContact";
        } else {
            util.UtilMensagens.erro("Erro");
            return null;
        }
    }

    public List<Contact> getList() {
        return list;
    }

    public void setList(List<Contact> list) {
        this.list = list;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

}

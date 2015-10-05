/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package controler;

import Beans.Contact;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Arthur
 */
@ManagedBean(name = "controlerContactMB")
@SessionScoped
public class controlerContact implements Serializable {

    private List<Contact> list;
    private Contact contact;
    private Boolean status; // If Status = true then the contact is new, else the user is editing
    private int i;

    /**
     * Creates a new instance of controlerContact
     */
    public controlerContact() {
        i = 0;
        list = new ArrayList();
        status = true;
    }

    public String remove(Contact contact) {
        list.remove(contact);
        return "viewContact?faces-redirect=true";
    }

    public String newContact() {
        contact = new Contact();
        status = true;
        return "insertContact";
    }

    public String insert() {
        contact.setId(i++);
        list.add(contact);
        return "viewContact";
    }

    public String change(Contact contact) {
        this.contact = contact;
        contact.setBirth_date(null);// Clear the calendars
        status = false;
        return "insertContact";
    }

    public String makeChange() {
        if (list.contains(this)) {            
            list.add(contact.getId(), contact);
        }
        return "viewContact";
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
   
}

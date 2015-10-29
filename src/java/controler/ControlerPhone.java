/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package controler;

import model.Phone;
import dao.ContactDao;
import dao.PhoneDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Contact;

/**
 *
 * @author Arthur
 */
@ManagedBean(name = "controlerPhoneMB")
@SessionScoped
public class ControlerPhone implements Serializable {

    private List<Phone> list;
    private Phone phone;
    private Boolean status; // If Status = true then the city is new, else the user is editing
    private int i;
    private final PhoneDao phoneDao;
    private Boolean mainPhone;
    private int id_Contact;
    private Contact contact;

    /**
     * Creates a new instance of ControlerPhone
     */
    public ControlerPhone() {
        status = true;
        phoneDao = new PhoneDao();
        list = new ArrayList();
        list = phoneDao.list();
        i = 0;
    }

    public String newPhone() {
        phone = new Phone();
        status = true;
        return "insertPhone";
    }

    public String remove(Phone phone) {
        if (phoneDao.delete(phone)) {
            list = phoneDao.list();
            util.UtilMensagens.success("Sucess");
            return "viewPhone?faces-redirect=true";
        } else {
            util.UtilMensagens.erro("Erro");
            return null;
        }
    }

    private void defineContact() {
        ContactDao contactDao = new ContactDao();
        contact = contactDao.search(id_Contact);
        phone.setContactid(contact);
        if (mainPhone == true) {
            phone.setMain("Yes");
        } else {
            phone.setMain("No");
        }
    }

    public String insert() {
        defineContact();
        // Gambiarra always way comented!
        // Check if there is a main phone on list
        if (phone.getMain().equals("Yes")) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getContactid().getId() == phone.getContactid().getId()) {
                    if (list.get(j).getMain() == phone.getMain()) {
                        // Then, the user already have a "main" fone
                        phone.setPhone(null);
                        i = i - 1;
                        util.UtilMensagens.erro("User already have a main phone");
                        phone = new Phone();
                        return "insertPhone";  // Find a way to show a message to user                  
                    }
                }
            }
        }
        // Gambiarra`s end
        if (phoneDao.insert(phone)) {
            list = phoneDao.list();
            util.UtilMensagens.success("Sucess");
            return "viewPhone";
        } else {
            util.UtilMensagens.erro("Erro");
            return null;
        }
    }

    public String change(Phone phone) {
        this.phone = phone;
        status = false;
        return "insertPhone";
    }

    public String makeChange() {
        defineContact();
        if (phoneDao.change(phone)) {
            list = phoneDao.list();
            util.UtilMensagens.success("Sucess");
            return "viewPhone";
        } else {
            util.UtilMensagens.erro("Erro");
            return null;
        }
    }

    public List<Phone> getList() {
        return list;
    }

    public void setList(List<Phone> list) {
        this.list = list;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
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

    public int getId_Contact() {
        return id_Contact;
    }

    public void setId_Contact(int id_Contact) {
        this.id_Contact = id_Contact;
    }

    public Boolean getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(Boolean mainPhone) {
        this.mainPhone = mainPhone;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

}

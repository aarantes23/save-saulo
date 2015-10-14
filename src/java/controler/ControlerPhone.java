/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package controler;

import Beans.Phone;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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

    /**
     * Creates a new instance of ControlerPhone
     */
    public ControlerPhone() {
        i = 0;
        list = new ArrayList();
        status = true;
    }

    public String remove(Phone phone) {
        list.remove(phone);
        return "viewPhone?faces-redirect=true";
    }

    public String newPhone() {
        phone = new Phone();
        status = true;
        return "insertPhone";
    }

    public String insert() {
        phone.setId(i++);
        // Gambiarra always way comented!
        // Check if there is a main fone on list
        if (phone.getMain() == true) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getId_Contact() == phone.getId_Contact()) {
                    if (list.get(j).getMain() == phone.getMain()) {
                        // Then, the user already have a "main" fone
                        phone.setPhone(null);
                        i = i - 1;
                        FacesContext.getCurrentInstance().
                                addMessage(null,
                                        new FacesMessage(
                                                FacesMessage.SEVERITY_INFO,
                                                "User Already have a main phone",
                                                "User Already have a main phone"));
                        phone = new Phone();
                        return "insertPhone";  // Find a way to show a message to user                  
                    }
                }
            }
        }
        // Gambiarra`s end
        list.add(phone);
        return "viewPhone";
    }

    public String change(Phone phone) {
        this.phone = phone;
        status = false;
        return "insertPhone";
    }

    public String makeChange() {
        if (list.contains(this)) {
            list.add(phone.getId(), phone);
        }
        return "viewPhone";
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

}

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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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

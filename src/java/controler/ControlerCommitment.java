/*
 * Developed by Arthur Arantes Faria 
 * Graduating in Computer Science on UNIFOR-MG BRASIL
 * arthurarantes23@hotmail.com
 */
package controler;

import Beans.Commitment;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Arthur
 */
@ManagedBean(name = "controlerCommitmentMB")
@SessionScoped
public class ControlerCommitment implements Serializable {

    private List<Commitment> list;
    private Commitment commitment;
    private Boolean status; // If Status = true then the city is new, else the user is editing
    private int i;

    /**
     * Creates a new instance of ControlerCity
     */
    public ControlerCommitment() {
        i = 0;
        list = new ArrayList();
        status = true;
    }

    public String remove(Commitment commitment) {
        list.remove(commitment);
        return "viewCommitment?faces-redirect=true";
    }

    public String newCommitment() {
        commitment = new Commitment();        
        status = true;
        return "insertCommitment";
    }

    public String insert() {        
        commitment.setId(i++);
        list.add(commitment);
        return "viewCommitment";
    }

    public String change(Commitment commitment) {        
        this.commitment = commitment;
        commitment.setDate_start(null);
        commitment.setDate_end(null);
        commitment.setHour_start(null);
        commitment.setHour_end(null);        
        status = false;
        return "insertCommitment";
    }

    public String makeChange() {
        if (list.contains(this)) {
            list.add(commitment.getId(), commitment);
        }
        return "viewCommitment";
    }

    public List<Commitment> getList() {
        return list;
    }

    public void setList(List<Commitment> list) {
        this.list = list;
    }

    public Commitment getCommitment() {
        return commitment;
    }

    public void setCommitment(Commitment commitment) {
        this.commitment = commitment;
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
